package org.drools.model.script;

import org.drools.model.script.complier.RuleCommand;
import org.drools.model.script.complier.RuleConstructContent;
import org.drools.model.script.complier.RuleDefineCommand;
import org.drools.model.script.complier.RuleHeaderCommand;
import org.drools.model.script.complier.RuleLhsCommand;
import org.drools.model.script.complier.RuleRhsCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * DRL Script 构建
 * @author : kenny
 * @since : 2023/8/30
 **/
public class RuleScriptExecutor{
    private final DynamicScript context;
    private final List<RuleCommand> ruleCommands;

    public String getScript(){
        return context.getRuleScript().toString();
    }

    public RuleScriptExecutor(RuleConstructContent RuleConstructContent) {
        context = new DynamicScript(RuleConstructContent);
        ruleCommands = new ArrayList<>();
        ruleCommands.add(new RuleHeaderCommand());
        ruleCommands.add(new RuleDefineCommand());
        ruleCommands.add(new RuleLhsCommand());
        ruleCommands.add(new RuleRhsCommand());
        execute();
    }

    public void execute() {
        ruleCommands.forEach(item -> item.apply(context));
    }

}
