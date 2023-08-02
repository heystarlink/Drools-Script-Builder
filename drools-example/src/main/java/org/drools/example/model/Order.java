package org.drools.example.model;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class Order {
    private int orderId;
    private double amount;
    private double discount;

    public Order(int orderId, double amount, double discount) {
        this.orderId = orderId;
        this.amount = amount;
        this.discount = discount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public static void main(String[] args) {
        KieServices kieServices = KieServices.get();

        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // 创建KieSession
        KieSession kieSession = kieContainer.newKieSession();

        // 创建订单对象
        Order order = new Order(1, 1200, 100);

        // 将订单对象插入到KieSession中
        kieSession.insert(order);

        // 设置当前的AgendaGroup为"ValidationGroup"
        kieSession.getAgenda().getAgendaGroup("ValidationGroup").setFocus();

        // 执行规则
        kieSession.fireAllRules();

        // 设置当前的AgendaGroup为"DiscountGroup"
        kieSession.getAgenda().getAgendaGroup("DiscountGroup").setFocus();

        // 执行规则
        kieSession.fireAllRules();

        // 关闭KieSession
        kieSession.dispose();

    }
}
