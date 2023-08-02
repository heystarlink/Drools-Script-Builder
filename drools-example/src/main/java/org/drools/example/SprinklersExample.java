package org.drools.example;

import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.drools.example.model.fire.Fire;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class SprinklersExample {


    public static void main(String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("BussPassBadKS");

        // 将火灾对象插入到工作内存中
        kieSession.insert(new Fire());
        // 只触发规则名称以 insert_ 开头的规则
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("insert"));

    }
}
