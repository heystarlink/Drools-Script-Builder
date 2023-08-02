package org.drools.model.script.complier;

import org.drools.constant.SignConstant;
import org.drools.enums.PackageScopeTypeEnum;
import org.drools.model.script.DynamicScript;

import java.util.List;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public class RuleHeaderCommand implements RuleCommand{
    @Override
    public boolean apply(DynamicScript context) {
        StringBuilder grammar = new StringBuilder();

        RuleConstructContent RuleConstructContent = context.getRuleConstructContent();

        List<RuleHeader> _headers = RuleConstructContent.getRuleHeaders();

        for (RuleHeader header : _headers){
            PackageScopeTypeEnum scopeTypeEnum = header.getScopeTypeEnum();
            String packagePath = header.getPackagePath();
            String variableName = header.getVariableName();

            grammar.append(scopeTypeEnum.getScope()).append(packagePath);

            if (PackageScopeTypeEnum.GLOBAL.equals(scopeTypeEnum)){
                grammar.append(SignConstant.SPACE).append(variableName);
            }

            grammar.append(SignConstant.SEMICOLON).append(SignConstant.NEW_LINE);
        }

        context.composition(grammar.toString());
        return true;
    }
}
