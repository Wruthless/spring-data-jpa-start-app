package com.wruthless.persistentcollections;

import com.wruthless.persistentcollections.model.Orders;
import com.wruthless.persistentcollections.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class PersistentCollectionsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PersistentCollectionsApplication.class, args);

        UserService userService = context.getBean(UserService.class);

        Users user = userService.processUser(1L);

        if (user != null) {
            System.out.println("User: " + user.getName());
        } else {
            System.out.println("[!] User not found.");
        }

        List<Orders> orders = userService.getUserOrders(1L);

        for (Orders order : orders) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("Product Name: " + order.getProductName());
        }

    }

}
