package com.feedback.demo.feedbackDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedback.demo.model.Feedback;

@Repository
public interface FeedbackDAO extends JpaRepository<Feedback, Integer>{
	
}
