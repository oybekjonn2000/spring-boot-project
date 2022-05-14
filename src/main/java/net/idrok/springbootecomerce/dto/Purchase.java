package net.idrok.springbootecomerce.dto;

import lombok.Data;
import net.idrok.springbootecomerce.entity.Address;
import net.idrok.springbootecomerce.entity.Customer;
import net.idrok.springbootecomerce.entity.Order;
import net.idrok.springbootecomerce.entity.OrderItem;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;


}
