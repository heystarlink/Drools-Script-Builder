package org.drools.model.script.complier;

import org.drools.enums.PackageScopeTypeEnum;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public class RuleHeader {
    private PackageScopeTypeEnum scopeTypeEnum;

    private final String packagePath;

    private String variableName;

    private RuleHeader(PackageScopeTypeEnum scopeTypeEnum, String packagePath) {
        this.scopeTypeEnum = scopeTypeEnum;
        this.packagePath = packagePath;
    }

    private RuleHeader(PackageScopeTypeEnum scopeTypeEnum, String packagePath, String variableName) {
        this.scopeTypeEnum = scopeTypeEnum;
        this.packagePath = packagePath;
        this.variableName = variableName;
    }

    public PackageScopeTypeEnum getScopeTypeEnum() {
        return scopeTypeEnum;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public String getVariableName() {
        return variableName;
    }

    public static RuleHeader createImportHeader(String packagePath) {
        return new RuleHeader(PackageScopeTypeEnum.IMPORT, packagePath);
    }

    public static RuleHeader createGlobalHeader(String packagePath, String variableName) {
        return new RuleHeader(PackageScopeTypeEnum.GLOBAL, packagePath, variableName);
    }
}
