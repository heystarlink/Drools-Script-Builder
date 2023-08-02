package org.drools.example;

import org.drools.example.model.focus.Fact;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaGroup;

import java.sql.Connection;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class DroolsAgendaGroupExample {
    public static void main(String[] args) throws ClassNotFoundException {
        // 创建 KieServices 和 KieContainer
        KieServices kieServices = KieServices.Factory.get();

        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // 创建 KieSession
        KieSession kieSession = kieContainer.newKieSession();

        // 获取 Agenda Group
        AgendaGroup agendaGroup = kieSession.getAgenda().getAgendaGroup("MyAgendaGroup");
        agendaGroup.setFocus();
        agendaGroup.clear();


        // 插入事实
        Fact fact = new Fact("test", 18); // 自定义事实对象
        kieSession.insert(fact);

        // 执行规则
        kieSession.fireAllRules();

        // 关闭 KieSession
        kieSession.dispose();
    }
}
