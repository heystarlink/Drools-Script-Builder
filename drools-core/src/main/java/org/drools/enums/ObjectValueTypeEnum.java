package org.drools.enums;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public enum ObjectValueTypeEnum {
    INTEGER("短整型", Integer.class.getName()),
    LONG("长整型", Long.class.getName()),
    DOUBLE("双精度浮点型", Double.class.getName()),
    BOOLEAN("布尔值", Boolean.class.getName()),
    LIST_INTEGER("list集合<短整型数字>", List.class.getName()),
    LIST_LONG("list集合<长整型数字>", List.class.getName()),
    LIST_STRING("list集合<字符串>", List.class.getName()),
    STRING("字符串", String.class.getName()),
    BIG_DECIMAL("高精度数字", BigDecimal.class.getName()),
    DATE("时间类型", Date.class.getName());

    private String name;

    private String value;

    ObjectValueTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static List<ExpressionEnum> getOptList(ObjectValueTypeEnum objectValueTypeEnum) {
        if (objectValueTypeEnum == null) {
            return new ArrayList<>();
        }

        switch (objectValueTypeEnum) {
            case LONG:
            case DOUBLE:
            case INTEGER:
            case BIG_DECIMAL:
                return Arrays.asList(ExpressionEnum.EQ, ExpressionEnum.NOT_EQ, ExpressionEnum.GT, ExpressionEnum.GTE, ExpressionEnum.LT, ExpressionEnum.LTE,  ExpressionEnum.IS_NULL, ExpressionEnum.IS_NOT_NULL);
            case DATE:
                return Arrays.asList(ExpressionEnum.GT, ExpressionEnum.GTE, ExpressionEnum.LT, ExpressionEnum.LTE, ExpressionEnum.EQ, ExpressionEnum.IS_NULL, ExpressionEnum.IS_NOT_NULL);
            case BOOLEAN:
                return Arrays.asList(ExpressionEnum.EQ, ExpressionEnum.NOT_EQ);
            case LIST_STRING:
            case LIST_INTEGER:
            case LIST_LONG:
                return Arrays.asList(ExpressionEnum.IN, ExpressionEnum.NOT_IN, ExpressionEnum.IS_NULL, ExpressionEnum.IS_NOT_NULL);
            case STRING:
                return Arrays.asList(ExpressionEnum.EQ, ExpressionEnum.NOT_EQ, ExpressionEnum.CONTAINS, ExpressionEnum.NOT_CONTAINS, ExpressionEnum.IS_NULL, ExpressionEnum.IS_NOT_NULL);
        }

        return new ArrayList<>();
    }


    /*public static List<ExpressionEnum> getOptList(ObjectValueTypeEnum objectValueTypeEnum) {
        if (objectValueTypeEnum == null) {
            return new ArrayList<>();
        }

        switch (objectValueTypeEnum) {
            case LONG:
            case DOUBLE:
            case INTEGER:
                return Arrays.asList(ExpressionEnum.EQ, ExpressionEnum.NOT_EQ, ExpressionEnum.GT, ExpressionEnum.GTE, ExpressionEnum.LT, ExpressionEnum.LTE, ExpressionEnum.IN, ExpressionEnum.NOT_IN, ExpressionEnum.IS_NULL, ExpressionEnum.IS_NOT_NULL);
            case BIG_DECIMAL:
                return Arrays.asList(ExpressionEnum.EQ, ExpressionEnum.NOT_EQ, ExpressionEnum.GT, ExpressionEnum.GTE, ExpressionEnum.LT, ExpressionEnum.LTE, ExpressionEnum.IS_NULL, ExpressionEnum.IS_NOT_NULL);
            case DATE:
                return Arrays.asList(ExpressionEnum.GT, ExpressionEnum.GTE, ExpressionEnum.LT, ExpressionEnum.LTE, ExpressionEnum.EQ, ExpressionEnum.IS_NULL, ExpressionEnum.IS_NOT_NULL);
            case BOOLEAN:
                return Arrays.asList(ExpressionEnum.EQ, ExpressionEnum.NOT_EQ);
            case LIST_STRING:
            case LIST_INTEGER:
            case LIST_LONG:
                return Arrays.asList(ExpressionEnum.CONTAINS, ExpressionEnum.NOT_CONTAINS, ExpressionEnum.IS_NULL, ExpressionEnum.IS_NOT_NULL);
            case STRING:
                return Arrays.asList(ExpressionEnum.EQ, ExpressionEnum.NOT_EQ, ExpressionEnum.IN, ExpressionEnum.NOT_IN, ExpressionEnum.IS_NULL, ExpressionEnum.IS_NOT_NULL);
        }

        return new ArrayList<>();
    }*/

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
