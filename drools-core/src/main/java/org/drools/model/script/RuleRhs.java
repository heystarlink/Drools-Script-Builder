package org.drools.model.script;

import lombok.Data;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
@Data
public class RuleRhs {
    /** 规则名 **/
    private String ruleName;

    /** 当前命中规则优先级 **/
    private Integer salience;

    /** 类型值 **/
    private String typeValue;

    /** 执行类 **/
    private Class<?> executeClass;
}
