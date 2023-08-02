package org.drools.example;

import org.drools.example.model.buspass.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import org.kie.api.runtime.rule.FactHandle;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class FocusExample {

    public static void main(String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("BussPassBadKS");
        Person p = new Person("Yoda", 18);

        FactHandle fh = ksession.insert(p);

        Agenda agenda = ksession.getAgenda();

        agenda.getAgendaGroup( "calculation" ).setFocus();
        agenda.getAgendaGroup( "report" ).setFocus();

        p.setAge(13);
        ksession.update(fh, p);
        ksession.fireAllRules();

        //ksession.getAgenda().getAgendaGroup( "calculation" ).clear();
    }
}
