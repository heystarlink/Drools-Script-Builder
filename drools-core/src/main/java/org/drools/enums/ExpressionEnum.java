package org.drools.enums;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public enum ExpressionEnum {
    GT(" > ", "大于", 1),
    GTE(" >= ", "大于等于", 2),
    LT(" < ", "小于", 3),
    LTE(" <= ", "小于等于", 4),
    EQ(" == ", "等于", 5),
    NOT_EQ(" != ", "不等于", 6),
    IN(" memberOf ", "在集合之内", 7),
    NOT_IN(" not memberOf ", "不在集合之内", 8),
    CONTAINS(" contains ", "包含", 9),
    NOT_CONTAINS(" not contains ", "不包含", 10),
    MATCHES(" matches ", "匹配", 11),
    NOT_MATCHES(" not matches ", "不匹配", 12),
    BETWEEN(" between ", "在时间范围之内", 13),
    IS_NULL(" is null ", "为空", 14),
    IS_NOT_NULL(" is not null ", "不为空", 15),

    ;
    private final String operation;
    private final String operationDescription;
    private final Integer operationCode;

    ExpressionEnum(String operation, String operationDescription, Integer operationCode) {
        this.operation = operation;
        this.operationDescription = operationDescription;
        this.operationCode = operationCode;
    }

    public String getOperation() {
        return operation;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public Integer getOperationCode() {
        return operationCode;
    }
}
