package com.feedback.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.Feedback;
import com.feedback.demo.service.FeedbackService;

@RestController
public class FeedbackController{
		
	@Autowired
	public FeedbackService service;

		@PostMapping("/feedback")
		public Feedback createFeedback(@RequestBody Feedback feedback) {
			
			return service.createFeedback(feedback);
		}

		@GetMapping("/feedback/{id}")
		public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") int id) {
			
				//return (ResponseEntity<Feedback>) new ResponseEntity<Feedback>(service.getFeedbackById(id),HttpStatus.OK);
			try {
				return new ResponseEntity<Feedback>(service.getFeedbackById(id),HttpStatus.OK);
			} catch (BusinessException e) {
				
				return new ResponseEntity<Feedback>(null,null, HttpStatus.NOT_FOUND);
			}
		}

		@PutMapping("/feedback")
		public Feedback updateFeedback(@RequestBody Feedback feedback) {
			
			return service.updateFeedback(feedback);
		}

		@DeleteMapping("/feedback/{id}")
		public void deleteFeedback(@PathVariable("id") int id) {
			
			service.deleteFeedback(id);
		}

		@GetMapping("/feedbacks")
		public List<Feedback> getAllFeedbacks() {
			
			return service.getAllFeedbacks();
		}

}
