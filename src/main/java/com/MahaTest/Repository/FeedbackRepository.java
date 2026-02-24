package com.MahaTest.Repository;

import com.MahaTest.Entity.FeedbackForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<FeedbackForm, Long> {
    List<FeedbackForm> findByStudentMobNo(String mobNo);
}

