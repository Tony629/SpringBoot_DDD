package com.javaguide.web;

import com.javaguide.application.order.createOrder.CreateOrderCmd;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tony Zhang
 **/
@RestController
public class OrderController {
    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderController(ApplicationEventPublisher applicationEventPublisher){
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PostMapping("/api/orders")
    public String receiveOrder(){
        CreateOrderCmd createOrderCmd = new CreateOrderCmd();
        createOrderCmd.setShippingAddress("USD");

        this.applicationEventPublisher.publishEvent(createOrderCmd);

        return "202412261500";
    }

}
