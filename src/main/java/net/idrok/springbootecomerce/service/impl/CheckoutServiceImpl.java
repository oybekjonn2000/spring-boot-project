package net.idrok.springbootecomerce.service.impl;

import net.idrok.springbootecomerce.Repository.CustomerRepository;
import net.idrok.springbootecomerce.dto.Purchase;
import net.idrok.springbootecomerce.dto.PurchaseResponse;
import net.idrok.springbootecomerce.entity.Customer;
import net.idrok.springbootecomerce.entity.Order;
import net.idrok.springbootecomerce.entity.OrderItem;
import net.idrok.springbootecomerce.service.CheckoutService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CustomerRepository customerRepository;


    public CheckoutServiceImpl(CustomerRepository customerRepository){
     this.customerRepository =customerRepository;
    }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto

        Order order = purchase.getOrder();

        //generate tracking number

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item-> order.add(item));

        //populate order with BillingAddress and Shipping Address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();


        // check if this is an existing customer

        String theEmail = customer.getEmail();
        Customer customerFromDB = customerRepository.findByEmail(theEmail);
        if(customerFromDB !=null){
            // we found them .. lets assign them accordingly
            customer =customerFromDB;
        }

        customer.add(order);

        //save to the database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
     return UUID.randomUUID().toString();
    }
}
