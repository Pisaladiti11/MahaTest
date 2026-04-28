package com.MahaTest.Controller;


import com.MahaTest.Entity.Payment;
import com.MahaTest.Repository.PaymentRepository;
import com.MahaTest.Service.PaymentService;
import com.razorpay.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin("https://mahastudy.in/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentRepository paymentRepository;

    // ✅ Create Order
    @PostMapping("/create-order")
    public String createOrder(@RequestParam int amount) throws Exception {

        Order order = paymentService.createOrder(amount);

        Payment payment = new Payment();
        payment.setOrderId(order.get("id"));
        payment.setAmount(amount);
        payment.setStatus("CREATED");

        paymentRepository.save(payment);

        return order.toString(); //  FIX
    }
    // ✅ Verify Payment
    @PostMapping("/verify")
    public String verifyPayment(@RequestBody Payment request) {

        boolean isValid = paymentService.verifyPayment(
                request.getOrderId(),
                request.getPaymentId(),
                request.getSignature()
        );

        Payment payment = new Payment();
        payment.setOrderId(request.getOrderId());
        payment.setPaymentId(request.getPaymentId());
        payment.setSignature(request.getSignature());
        payment.setStatus(isValid ? "SUCCESS" : "FAILED");

        paymentRepository.save(payment);

        return isValid ? "Payment Successful" : "Payment Failed";
    }
}
