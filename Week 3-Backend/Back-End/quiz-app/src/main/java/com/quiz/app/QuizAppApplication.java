package com.quiz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.quiz.app.dao.AnswerDAO;
import com.quiz.app.dao.QuestionDAO;
import com.quiz.app.model.Answer;
import com.quiz.app.model.Question;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.quiz.app")

public class QuizAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}
	
	@Autowired
	QuestionDAO questionDao;
	@Autowired
	AnswerDAO answerDao;
	
   
	@Override
	public void run(String... args) throws Exception {
		
	
		Question question = new Question();
		question.setQuestion1("What is the color of the sky?");
		question.setQuestion2("How many finger do you have?");
		question.setQuestion3("Is spring boot a RAD tool, T or F?");

		Answer answer = new Answer();
		answer.setCorrectAnswer1("blue");
		answer.setCorrectAnswer2("10");
		answer.setCorrectAnswer3("T");
		
		
		questionDao.save(question);
		answerDao.save(answer);
		
	
	
}
}
