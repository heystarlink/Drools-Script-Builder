package org.drools.enums;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public enum DefaultPackage {
    ARRAYLIST("import java.util.ArrayList;"),
    HASHMAP("import java.util.Map;")
    ;

    DefaultPackage(String path) {
        this.path = path;
    }

    private String path;
}
