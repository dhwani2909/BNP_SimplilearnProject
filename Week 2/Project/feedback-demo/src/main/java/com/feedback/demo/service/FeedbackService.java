package com.feedback.demo.service;

import java.util.List;

import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.Feedback;

public interface FeedbackService{
	
	public Feedback createFeedback(Feedback feedback);
	public Feedback getFeedbackById(int id) throws BusinessException;
	public Feedback updateFeedback(Feedback feedback);
	public void deleteFeedback(int id);
	public List<Feedback> getAllFeedbacks();
}
