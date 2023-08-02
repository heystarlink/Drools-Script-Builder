package org.drools.enums;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public enum PackageScopeTypeEnum {
    PACKAGE(1, "package "),
    IMPORT(3, "import "),
    GLOBAL(2, "global "),
    ;

    private final Integer code;
    private final String scope;
    PackageScopeTypeEnum(Integer code, String scope) {
        this.code = code;
        this.scope = scope;
    }

    public Integer getCode() {
        return code;
    }

    public String getScope() {
        return scope;
    }
}
