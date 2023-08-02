package org.drools.model.script.complier;

import org.drools.constant.SignConstant;
import org.drools.model.script.DynamicScript;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public class RuleDefineCommand implements RuleCommand{

    @Override
    public boolean apply(DynamicScript context) {
        StringBuilder grammar = new StringBuilder();
        RuleConstructContent RuleConstructContent = context.getRuleConstructContent();

        grammar.append(SignConstant.NEW_LINE);
        grammar.append("rule ").append(SignConstant.DOUBLE_QUOTES).append(RuleConstructContent.getRuleName()).append(SignConstant.DOUBLE_QUOTES).append(SignConstant.NEW_LINE);

        if (RuleConstructContent.getSalience() != null){
            grammar.append("salience ").append(RuleConstructContent.getSalience()).append(SignConstant.NEW_LINE);
        }

        if (RuleConstructContent.getRuleGroup() != null && !RuleConstructContent.getRuleGroup().isEmpty()){
            grammar.append("ruleflow-group ").append(SignConstant.DOUBLE_QUOTES).append(RuleConstructContent.getRuleGroup()).append(SignConstant.DOUBLE_QUOTES).append(SignConstant.NEW_LINE);
            grammar.append("activation-group ").append(SignConstant.DOUBLE_QUOTES).append(RuleConstructContent.getRuleGroup()).append(SignConstant.DOUBLE_QUOTES).append(SignConstant.NEW_LINE);
        }

        context.composition(grammar.toString());
        return true;
    }
}
