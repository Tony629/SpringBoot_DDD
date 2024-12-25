package com.javaguide.application.order;

import com.javaguide.application.contract.order.CreateOrderLineCmd;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @author Tony Zhang
 **/
@Getter
@Setter
public class CreateOrderCmd {
    private String shippingAddress;
    private double subtotal;
    private ArrayList<CreateOrderLineCmd> orderLines;
}
