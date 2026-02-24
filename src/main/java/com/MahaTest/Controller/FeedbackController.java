package com.MahaTest.Controller;


import com.MahaTest.Entity.FeedbackForm;
import com.MahaTest.Service.FeedbackService;
import com.MahaTest.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/submit")
    public FeedbackForm submitFeedback(@RequestBody FeedbackForm feedback, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String mobNo = jwtUtil.getMobNo(token);
            feedback.setStudentMobNo(mobNo);
        }
        return service.submitFeedback(feedback);
    }

    @GetMapping("/my")
    public List<FeedbackForm> getMyFeedback(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String mobNo = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            mobNo = jwtUtil.getMobNo(token);
        }
        return service.getFeedbacks(mobNo);
    }
}
