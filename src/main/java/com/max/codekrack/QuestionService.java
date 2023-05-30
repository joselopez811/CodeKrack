package com.max.codekrack;

import org.springframework.stereotype.Component;

@Component
public class QuestionService {
	
	private String language;
    private String question;
    private String code;
    private Integer answer;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
        
    @Override
	public String toString() {
		return "QuestionService \n[language=" + language + ",\nquestion=" + question + ", \ncode=" + code + ", \nanswer=" + answer + ", \nanswers="
				 + ", \nanswer1=" + answer1 + ", \nanswer2=" + answer2 + ", \nanswer3=" + answer3 + ", \nanswer4="
				+ answer4 + ", \nanswer5=" + answer5 + "]";
	}

	public QuestionService() {}
    
	public QuestionService(String language, String question, String code, Integer answer, String answer1,
			String answer2, String answer3, String answer4, String answer5) {
		super();
		this.language = language;
		this.question = question;
		this.code = code;
		this.answer = answer;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getAnswer5() {
		return answer5;
	}
	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

    
    
}
