package com.javaguide.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tony Zhang
 **/
@Getter
@Setter
public class OrderLineItem {
    private String uuid;
    private String sku;
    private int quantity;
    private double subtotal;
    private double price;
}
