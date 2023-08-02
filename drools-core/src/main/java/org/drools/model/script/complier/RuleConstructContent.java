package org.drools.model.script.complier;

import lombok.Data;
import org.drools.model.script.RuleLhs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
@Data
public class RuleConstructContent{
    /** 规则名称 **/
    private String ruleName;

    /** 规则组名称 **/
    private String ruleGroup;

    /** 优先级 **/
    private Integer salience;

    private boolean noLoop = false;

    /** 头部定义 **/
    private List<RuleHeader> ruleHeaders = new ArrayList<>() {{
        // 添加默认头部引入
        add(RuleHeader.createImportHeader("java.util.Map"));
        add(RuleHeader.createImportHeader("org.drools.model.script.RuleRhs"));
        add(RuleHeader.createGlobalHeader("java.util.Map", "resultMap"));
    }};

    /** LHS **/
    private RuleLhs ruleLhs;

    public void addRuleHeader(RuleHeader ruleHeader){
        ruleHeaders.add(ruleHeader);
    }
}
