package com.MahaTest.Service;

import com.MahaTest.Entity.FeedbackForm;
import java.util.List;

public interface FeedbackService {
    FeedbackForm submitFeedback(FeedbackForm feedback);
    List<FeedbackForm> getFeedbacks(String studentMobNo);
}

