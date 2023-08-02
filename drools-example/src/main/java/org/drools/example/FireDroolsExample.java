package org.drools.example;

import cn.hutool.core.collection.CollectionUtil;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class FireDroolsExample {
    // 制定规则文件的路径
    private static final String RULES_CUSTOMER_RULES_DRL = "rules/fact-test.drl";
    private static final KieServices kieServices = KieServices.Factory.get();

    public void fireAllRules(Object fact, Map<String, Object> globals){
        // 1. 创建 KieFileSystem 对象：创建一个 KieFileSystem 对象，用于表示规则文件系统
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        // 2. 将规则文件写入文件系统：将规则文件（在这里是从类路径中获取的 RULES_CUSTOMER_RULES_DRL 文件）写入 KieFileSystem
        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_CUSTOMER_RULES_DRL));

        // 3. 创建 KieBuilder 对象：创建一个 KieBuilder 对象，用于构建规则引擎的编译环境
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);

        // 4. 构建规则引擎：通过调用 kb.buildAll() 方法，对 KieBuilder 对象进行构建，将规则文件编译为可执行的规则引擎
        kb.buildAll();

        // 5. 获取 KieModule 对象：从 KieBuilder 对象中获取编译后的 KieModule 对象，该对象包含了已编译的规则和流程定义
        KieModule kieModule = kb.getKieModule();

        // 6. 创建 KieContainer 对象：使用 KieModule 的 ReleaseId 创建一个 KieContainer 对象，用于管理规则引擎的运行时环境
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        // 开启会话
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();

        if (CollectionUtil.isNotEmpty(globals)){
            globals.forEach(kieSession::setGlobal);
        }



        kieSession.execute(fact);
    }
}
