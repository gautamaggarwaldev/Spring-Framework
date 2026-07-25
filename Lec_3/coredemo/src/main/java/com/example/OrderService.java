package com.example;

import com.example.notification.NotificationService;

public class OrderService {

    NotificationService notification;

    public OrderService(NotificationService notification) {
        this.notification = notification;
    }
    public OrderService() {}
    
    public void placeOrder() {
        System.out.println("Order Placed");
        notification.sendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}
