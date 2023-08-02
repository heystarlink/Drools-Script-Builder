package org.drools.model.script.complier;

import cn.hutool.core.collection.CollectionUtil;
import org.drools.constant.SignConstant;
import org.drools.enums.ExpressionEnum;
import org.drools.enums.ObjectValueTypeEnum;
import org.drools.model.script.DynamicScript;
import org.drools.model.script.RuleLhs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public class RuleLhsCommand implements RuleCommand{

    @Override
    public boolean apply(DynamicScript context) {
        StringBuilder grammar = new StringBuilder();
        RuleConstructContent RuleConstructContent = context.getRuleConstructContent();
        RuleLhs ruleLhs = RuleConstructContent.getRuleLhs();

        grammar.append(SignConstant.WHEN);
        grammar.append(SignConstant.TABLE_SPACE);

        grammar.append("$exp :").append(ruleLhs.getReference()).append(" ").append("( ");
        for (Map.Entry<String, List<RuleLhs.RightCondition>> entry : ruleLhs.getExpressionMap().entrySet()) {
            String variable = entry.getKey();

            List<RuleLhs.RightCondition> conditions = entry.getValue();
            for (RuleLhs.RightCondition condition : conditions) {

                List<Object> values = condition.getValues();
                if (CollectionUtil.isEmpty(values)) {
                    throw new RuntimeException("表达式无值");
                }

                Object value = values.get(0);
                ExpressionEnum expressionEnum = condition.getExpression();
                ObjectValueTypeEnum objectValueTypeEnum = condition.getObjectValueTypeEnum();
                List<ExpressionEnum> optList = ObjectValueTypeEnum.getOptList(objectValueTypeEnum);
                if (!optList.contains(expressionEnum)) {
                    throw new RuntimeException("目标值不支持该操作类型");
                }

                grammar.append(variable).append(expressionEnum.getOperation());

                // 跳过空和非空判断
                if (expressionEnum.equals(ExpressionEnum.IS_NULL) || expressionEnum.equals(ExpressionEnum.IS_NOT_NULL)) {
                    continue;
                }

                if (ObjectValueTypeEnum.STRING.equals(objectValueTypeEnum)) {
                    grammar.append("\"").append(value).append("\"");
                } else if (ObjectValueTypeEnum.LIST_STRING.equals(objectValueTypeEnum)) {
                    List<String> obj2str = values.stream()
                            .map(s -> "\"" + s + "\"")
                            .collect(Collectors.toList());
                    grammar.append("[").append(String.join(", ", obj2str)).append("]");
                } else if (ObjectValueTypeEnum.INTEGER.equals(objectValueTypeEnum)
                        || ObjectValueTypeEnum.DOUBLE.equals(objectValueTypeEnum)
                        || ObjectValueTypeEnum.BIG_DECIMAL.equals(objectValueTypeEnum)
                        || ObjectValueTypeEnum.BOOLEAN.equals(objectValueTypeEnum)) {
                    grammar.append(value);
                } else if (ObjectValueTypeEnum.LIST_INTEGER.equals(objectValueTypeEnum)) {
                    grammar.append(values);
                } else if (ObjectValueTypeEnum.LONG.equals(objectValueTypeEnum)) {
                    grammar.append(value).append("L");
                } else if (ObjectValueTypeEnum.LIST_LONG.equals(objectValueTypeEnum)) {
                    List<String> obj2str = values.stream()
                            .map(s -> s + "L")
                            .collect(Collectors.toList());
                    grammar.append("[").append(String.join(", ", obj2str)).append("]");
                }

                grammar.append(" ");
                grammar.append(" && ");
            }

        }

        if (grammar.length() > 0) {
            grammar.delete(grammar.length() - 4, grammar.length()); // 删除最后多余的 " && "
        }

        grammar.append(")");
        grammar.append(SignConstant.NEW_LINE);
        context.composition(grammar.toString());
        return true;
    }
}
