package com.davCode.ecommerce.service;

import com.davCode.ecommerce.dto.Purchase;
import com.davCode.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
