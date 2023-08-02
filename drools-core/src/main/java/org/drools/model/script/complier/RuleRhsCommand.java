package org.drools.model.script.complier;

import org.drools.constant.SignConstant;
import org.drools.model.script.DynamicScript;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public class RuleRhsCommand implements RuleCommand{

    @Override
    public boolean apply(DynamicScript context) {
        StringBuilder action = new StringBuilder();

        RuleConstructContent RuleConstructContent = context.getRuleConstructContent();

        action.append(SignConstant.THEN);

        action.append(SignConstant.TABLE_SPACE).append("RuleRhs ruleRhs = new RuleRhs()").append(SignConstant.SEMICOLON).append(SignConstant.NEW_LINE);
        action.append(SignConstant.TABLE_SPACE).append("ruleRhs.setRuleName(\"" + RuleConstructContent.getRuleName() + "\");\r\n");
        action.append(SignConstant.TABLE_SPACE).append("ruleRhs.setSalience(" + RuleConstructContent.getSalience() + ");\r\n");
        action.append(SignConstant.TABLE_SPACE).append("System.out.println(\"=>>>>>>\" + drools.getRule().getName());").append("\n");
        action.append(SignConstant.TABLE_SPACE).append("resultMap.put(drools.getRule().getName(), ruleRhs);");

        action.append(SignConstant.NEW_LINE);
        action.append(SignConstant.END);
        context.composition(action.toString());
        return true;
    }
}
