package org.drools.model.script;

import lombok.Data;
import org.drools.enums.ExpressionEnum;
import org.drools.enums.ObjectValueTypeEnum;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public class RuleLhs {
    /** 评估引用名 */
    private String reference;

    /** 字段与表达式*/
    private LinkedHashMap<String, List<RightCondition>> expressionMap;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LinkedHashMap<String, List<RightCondition>> getExpressionMap() {
        return expressionMap;
    }

    public void setExpressionMap(LinkedHashMap<String, List<RightCondition>> expressionMap) {
        this.expressionMap = expressionMap;
    }

    @Data
    public static class RightCondition {
        /** 操作类型 **/
        private ExpressionEnum expression;

        /** 值 **/
        private List<Object> values;

        /** 值类型 **/
        private ObjectValueTypeEnum objectValueTypeEnum;
    }
}
