package com.quiz.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.model.Answer;

@Repository
public interface AnswerDAO extends JpaRepository<Answer, Integer>{
	
//	public Answer postAnswers(Answer answer);
//	public void setAnswers(Answer answer);
//	public List<String> getResult(Answer answer);
}
