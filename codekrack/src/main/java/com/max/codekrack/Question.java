package com.max.codekrack;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.max.codekrack.databaseutil.DatabaseUtil;

@Component
public class Question {

	private int id;
	private String question;
	private Code code;
	private Answer[] answers = new Answer[5];
	private int answerId;

	@Override
	public String toString() {
		
		return "Question [question=" + question + ", code=" + code + ", answers=" + answers + "]";
	}
	
	public Question() {
		this.id = (DatabaseUtil.getId());
		this.question = DatabaseUtil.getQuestion();
		this.code = new Code();
		this.answers = (DatabaseUtil.getAnswers());
		System.out.println("question id = " + id);
		System.out.println("answer =  " + answers[0].getAnswerId());
		
	}


	public Question(int id, String question, Code code, Answer[] answers, int answerId) {
		super();
		this.id = id;
		this.question = question;
		this.code = code;
		this.answers = answers;
		this.answerId = answerId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int id) {
		this.answerId = id;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Code getCode() {
		return code;
	}

	public Answer[] getAnswers() {
		return answers;
		
	}

	public void setAnswers(Answer[] answers) {
		this.answers = answers;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public static Answer[] randomizeArray(Answer[] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    Answer temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	
}
