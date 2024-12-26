package com.javaguide.domain;

import com.javaguide.application.contract.order.CreateOrderLineCmd;
import com.javaguide.application.order.createOrder.CreateOrderCmd;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * @author Tony Zhang
 **/
@Getter
@Setter
public class Order {
    private String uuid;
    private String orderNumber;
    private String shippingAddress;
    private double subtotal;

    private ArrayList<OrderLineItem> orderLineItems;

    private String status;

    /**
     * Create an order
     */
    public static Order create(CreateOrderCmd createOrderCmd){
        Order order = new Order();
        order.setUuid(UUID.randomUUID().toString());
        order.setOrderNumber(generateOrderNumber());
        order.setShippingAddress(createOrderCmd.getShippingAddress());
        order.setStatus("NEW");

        order.setSubtotal(createOrderCmd.getOrderLines().stream().mapToDouble(x-> x.getSubtotal()).sum());

        ArrayList<OrderLineItem> orderLines =  new ArrayList<>();
        for (CreateOrderLineCmd orderLineCmd : createOrderCmd.getOrderLines()) {
            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setUuid(UUID.randomUUID().toString());
            orderLineItem.setQuantity(orderLineCmd.getQuantity());
            orderLineItem.setPrice(orderLineCmd.getPrice());
            orderLineItem.setSubtotal(orderLineCmd.getSubtotal());

            orderLines.add(orderLineItem);
        }

        return order;

    }

    public void packed() {
        this.setStatus("PACKED");
    }

    public void shipped(){
        this.setStatus("SHIPPED");
    }

    public void accepted() {
        this.setStatus("COMPLETED");
    }

    private static String generateOrderNumber() {
        Random random = new Random();
        int randomNumber = 10000000 + random.nextInt(90000000);

        return "00" + randomNumber;
    }
}
