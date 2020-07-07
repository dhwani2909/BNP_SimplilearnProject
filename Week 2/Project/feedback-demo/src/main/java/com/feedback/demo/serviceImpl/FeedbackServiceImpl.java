package com.feedback.demo.serviceImpl;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.feedbackDao.FeedbackDAO;
import com.feedback.demo.model.Feedback;
import com.feedback.demo.service.FeedbackService;
@Service
public class FeedbackServiceImpl implements FeedbackService{
	@Autowired
	private FeedbackDAO dao;
	@Override
	public Feedback createFeedback(Feedback feedback) {
		
		return dao.save(feedback);
	}

	@Override
	public Feedback getFeedbackById(int id) throws BusinessException {
		if(id<=0) {
			throw new BusinessException("Id "+id +" is invalid");
		}
		Feedback feedback=null;
		try {
		feedback=dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No feedback found for id "+id);
		}
		return feedback;
	}
	
	@Override
	public Feedback updateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return dao.save(feedback);
	}

	@Override
	public void deleteFeedback(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
}
