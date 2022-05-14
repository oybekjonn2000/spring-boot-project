package net.idrok.springbootecomerce.controller;

import net.idrok.springbootecomerce.dto.Purchase;
import net.idrok.springbootecomerce.dto.PurchaseResponse;
import net.idrok.springbootecomerce.service.CheckourService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/checkout")
public class CheckoutController {

    private CheckourService checkourService;

    public CheckoutController(CheckourService checkourService){
        this.checkourService= checkourService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeorder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse= checkourService.placeOrder(purchase);
        return purchaseResponse;
    }

}
