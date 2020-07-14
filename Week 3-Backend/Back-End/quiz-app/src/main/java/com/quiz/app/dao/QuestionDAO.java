package com.quiz.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
	
//	public void setQuestions(Question question);
//	public List<Question> getQuestions();
}
