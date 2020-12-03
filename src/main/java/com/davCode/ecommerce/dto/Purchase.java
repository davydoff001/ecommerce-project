package com.davCode.ecommerce.dto;

import com.davCode.ecommerce.entity.Address;
import com.davCode.ecommerce.entity.Customer;
import com.davCode.ecommerce.entity.Order;
import com.davCode.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

    public Order getOrder() {
        return order;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Customer getCustomer() {
        return customer;
    }
}
