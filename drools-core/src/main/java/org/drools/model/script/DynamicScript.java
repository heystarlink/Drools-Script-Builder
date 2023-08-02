package org.drools.model.script;

import org.drools.model.script.complier.RuleConstructContent;

/**
 * 动态脚本
 * @author : kenny
 * @since : 2023/8/30
 **/
public class DynamicScript {
    /** 当前构建脚本内容 */
    private final StringBuilder ruleScript = new StringBuilder();

    /** 执行属性 */
    private final RuleConstructContent ruleConstructContent;

    public DynamicScript(RuleConstructContent ruleConstructContent) {
        this.ruleConstructContent = ruleConstructContent;
    }

    public void composition(String val){
        ruleScript.append(val);
    }

    public StringBuilder getRuleScript() {
        return ruleScript;
    }

    public RuleConstructContent getRuleConstructContent() {
        return ruleConstructContent;
    }
}
