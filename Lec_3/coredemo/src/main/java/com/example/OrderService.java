package com.example;

import com.example.notification.SmsService;
import com.example.notification.NotificationService;

public class OrderService {

    NotificationService notification = new SmsService();
    
    public void placeOrder() {
        System.out.println("Order Placed");
        notification.sendNotification();
        // video 4 --- 17:04
    }
}
