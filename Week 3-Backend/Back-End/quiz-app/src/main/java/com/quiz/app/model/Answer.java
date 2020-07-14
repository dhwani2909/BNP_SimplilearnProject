package com.quiz.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Answer{

	
	@OneToOne
	private Question question;
	
	
	private int userAnswerId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int correctAnswerId;
	
	
	private String userAnswer1;
	
	private String userAnswer2;
	
	private String userAnswer3;
	
	
	private String correctAnswer1;
	private String correctAnswer2;
	private String correctAnswer3;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Answer(int userAnswerId, String userAnswer1, String userAnswer2, String userAnswer3) {
		super();
		this.userAnswerId = userAnswerId;
		this.userAnswer1 = userAnswer1;
		this.userAnswer2 = userAnswer2;
		this.userAnswer3 = userAnswer3;
	}
	

	public int getUserAnswerId() {
		return userAnswerId;
	}

	public void setUserAnswerId(int userAnswerId) {
		this.userAnswerId = userAnswerId;
	}

	public int getCorrectAnswerId() {
		return correctAnswerId;
	}

	public void setCorrectAnswerId(int correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}

	public String getUserAnswer1() {
		return userAnswer1;
	}

	public void setUserAnswer1(String userAnswer1) {
		this.userAnswer1 = userAnswer1;
	}

	public String getUserAnswer2() {
		return userAnswer2;
	}

	public void setUserAnswer2(String userAnswer2) {
		this.userAnswer2 = userAnswer2;
	}

	public String getUserAnswer3() {
		return userAnswer3;
	}

	public void setUserAnswer3(String userAnswer3) {
		this.userAnswer3 = userAnswer3;
	}

	public String getCorrectAnswer1() {
		return correctAnswer1;
	}

	public void setCorrectAnswer1(String correctAnswer1) {
		this.correctAnswer1 = correctAnswer1;
	}

	public String getCorrectAnswer2() {
		return correctAnswer2;
	}

	public void setCorrectAnswer2(String correctAnswer2) {
		this.correctAnswer2 = correctAnswer2;
	}

	public String getCorrectAnswer3() {
		return correctAnswer3;
	}

	public void setCorrectAnswer3(String correctAnswer3) {
		this.correctAnswer3 = correctAnswer3;
	}
	
	
	
	
	
}
