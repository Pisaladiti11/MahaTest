package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.FeedbackForm;
import com.MahaTest.Repository.FeedbackRepository;
import com.MahaTest.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository repo;

    @Override
    public FeedbackForm submitFeedback(FeedbackForm feedback) {
        return repo.save(feedback);
    }

    @Override
    public List<FeedbackForm> getFeedbacks(String studentMobNo) {
        return repo.findByStudentMobNo(studentMobNo);
    }
}

