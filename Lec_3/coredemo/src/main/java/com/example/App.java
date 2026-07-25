package com.example;

import com.example.notification.EmailService;
import com.example.notification.NotificationService;

public class App 
{
    public static void main(String[] args) 
    {
        NotificationService notification = new EmailService();
        OrderService order = new OrderService();
        // OrderService order = new OrderService(notification);
        order.setNotification(notification);
        order.placeOrder();
    }
}
