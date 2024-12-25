package com.javaguide.application.contract.order;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tony Zhang
 **/
@Getter
@Setter
public class CreateOrderLineCmd {
    private int quantity;
    private double price;
    private double subtotal;
    private String sku;

    public double getSubtotal(){
        return price * quantity;
    }
}
