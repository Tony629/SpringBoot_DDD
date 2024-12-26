package com.javaguide.application.order.createOrder;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Tony Zhang
 **/
@Component
public class CreateOrderCmdHandler {
    public CreateOrderCmdHandler(){

    }

    @EventListener
    public void handle(CreateOrderCmd createOrderCmd){
        System.out.println("=============创建订单==============");
        System.out.println(createOrderCmd.getShippingAddress());
    }
}
