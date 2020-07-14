package com.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.model.Answer;
import com.quiz.app.model.Question;
import com.quiz.app.service.QuizService;


@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class UserController{
	
	@Autowired
	public QuizService service;

	@GetMapping("/quiz")
	public List<Question> getQuestions() {
		
		return service.getQuestions();
	}

	@PostMapping("/takequiz")
	public Answer postAnswers(@RequestBody Answer answer) {
	
		return service.postAnswers(answer);
	}
	
	@GetMapping("/quiz/{id}")
	public List<String> getResult(@PathVariable("id") int userId) {
		
		return service.getResult(userId);
	}

	@GetMapping("/attempts/{id}")
	public List<Answer> getAllAttemptsById(@PathVariable("id") int userAnswerId) {
		
		return service.getAllAttemptsById(userAnswerId);
	}
	
	
}
