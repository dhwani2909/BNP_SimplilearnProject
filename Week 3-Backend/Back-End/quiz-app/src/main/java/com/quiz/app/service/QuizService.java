package com.quiz.app.service;

import java.util.List;

import com.quiz.app.model.Answer;
import com.quiz.app.model.Question;


public interface QuizService {
	//display question to user
	public List<Question> getQuestions();
	public void setQuestions(Question question);
	
	//take answer from user.
	public Answer postAnswers(Answer answer);
	public void setAnswers(Answer answer);
	
	//review,result
	public List<String> getResult(int userAnswerId);
	public List<Answer> getAllAttemptsById(int userAnswerId);
	
	
	
}
