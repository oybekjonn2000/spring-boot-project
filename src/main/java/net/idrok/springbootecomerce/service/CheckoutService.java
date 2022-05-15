package net.idrok.springbootecomerce.service;

import net.idrok.springbootecomerce.dto.Purchase;
import net.idrok.springbootecomerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
