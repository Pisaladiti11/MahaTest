package com.MahaTest.Service;

import com.razorpay.Order;

public interface PaymentService {

    Order createOrder(int amount) throws Exception;

    boolean verifyPayment(String orderId, String paymentId, String signature);
}
