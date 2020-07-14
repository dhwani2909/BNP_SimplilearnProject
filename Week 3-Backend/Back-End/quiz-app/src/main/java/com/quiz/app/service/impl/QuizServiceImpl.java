package com.quiz.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.dao.AnswerDAO;
import com.quiz.app.dao.QuestionDAO;
import com.quiz.app.model.Answer;
import com.quiz.app.model.Question;
import com.quiz.app.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuestionDAO questionDao;
	@Autowired
	private AnswerDAO answerDao;
	
	
	private Question q;
	private Answer a;
	private List<Question> questionList;
	
	
	@Override
	public List<Question> getQuestions() {
	
		return questionDao.findAll();
	}

	@Override
	public void setQuestions(Question question) {
		
		Question q = new Question();
		//q.setQuestionId(question.getQuestionId());
		q.setQuestion1(question.getQuestion1());
		q.setQuestion2(question.getQuestion2());
		q.setQuestion3(question.getQuestion3());
		questionDao.save(q);
	}

	@Override
	public Answer postAnswers(Answer answer) {
		// TODO Auto-generated method stub
		Answer a = new Answer();
		a.setUserAnswer1(answer.getUserAnswer1());
		a.setUserAnswer2(answer.getUserAnswer2());
		a.setUserAnswer3(answer.getUserAnswer3());
		a.setUserAnswerId(answer.getUserAnswerId());
		a.setCorrectAnswer1("blue");
		a.setCorrectAnswer2("10");
		a.setCorrectAnswer3("T");
		
		return answerDao.save(a);
	}

	@Override
	public void setAnswers(Answer answer) {
		
		a.setCorrectAnswer1(answer.getCorrectAnswer1());
		a.setCorrectAnswer2(answer.getCorrectAnswer2());
		a.setCorrectAnswer3(answer.getCorrectAnswer3());
		
		
	}

	@Override
	public List<String> getResult(int userAnswerId) {
	
		List<Answer> answerList = new ArrayList<>();
		List<Answer> list1 = new ArrayList<>();
		list1 =  answerDao.findAll();
		List<String> string = new ArrayList<>();
		Integer id1 = userAnswerId;
		for(Answer a: list1) {
			
			Integer id2 = a.getUserAnswerId();
			 if((id1).equals(id2))
			 {
				 answerList.add(a);
			 }
			
		}
		
		for(Answer answer: answerList)
		{
			if(answer.getUserAnswer1().equalsIgnoreCase(answer.getCorrectAnswer1()) &&
					answer.getUserAnswer2().equalsIgnoreCase(answer.getCorrectAnswer2()) &&
							answer.getUserAnswer3().equalsIgnoreCase(answer.getCorrectAnswer3()))
			{
				 string.add("Congratulations! Answer is Correct. ");
			}
			
			else {
			
				string.add("Try Again! Answer is Incorrect. ");
			}
		}
		
		return string;
	}

	
	@Override
	public List<Answer> getAllAttemptsById(int userAnswerId) {
			
		 List<Answer> answerList = new ArrayList<>();
		List<Answer> list = new ArrayList<>();
		list =  answerDao.findAll();
		Integer id1 = userAnswerId;
		for(Answer a: list) {
			
			Integer id2 = a.getUserAnswerId();
			 if((id1).equals(id2))
			 {
				 answerList.add(a);
			 }
			
		}
		
		return answerList;
	}

}
