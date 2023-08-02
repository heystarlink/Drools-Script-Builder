package org.drools.example;

import org.drools.example.model.buspass.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class BussPassBadExample {


    public static void main(final String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("BussPassBadKS");

        Person p = new Person("Yoda", 15);

        FactHandle fh = ksession.insert(p);
        ksession.fireAllRules();

        p.setAge(20);
        ksession.update(fh, p);
        ksession.fireAllRules();
    }
}
