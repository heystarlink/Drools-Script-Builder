package org.drools.model.script.complier;

import org.drools.model.script.DynamicScript;

/**
 * @author : kenny
 * @since : 2023/8/30
 **/
public interface RuleCommand {
    boolean apply(DynamicScript context);
}
