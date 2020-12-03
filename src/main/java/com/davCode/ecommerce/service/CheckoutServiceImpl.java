package com.davCode.ecommerce.service;

import com.davCode.ecommerce.dao.CustomerRepsitory;
import com.davCode.ecommerce.dto.Purchase;
import com.davCode.ecommerce.dto.PurchaseResponse;
import com.davCode.ecommerce.entity.Customer;
import com.davCode.ecommerce.entity.Order;
import com.davCode.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepsitory customerRepsitory;

    @Autowired
    public CheckoutServiceImpl(CustomerRepsitory customerRepsitory){
        this.customerRepsitory = customerRepsitory;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        customer.add(order);

        customerRepsitory.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
