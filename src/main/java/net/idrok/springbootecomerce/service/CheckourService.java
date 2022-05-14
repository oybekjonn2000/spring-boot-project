package net.idrok.springbootecomerce.service;

import net.idrok.springbootecomerce.dto.Purchase;
import net.idrok.springbootecomerce.dto.PurchaseResponse;

public interface CheckourService {

    PurchaseResponse placeOrder(Purchase purchase);
}
