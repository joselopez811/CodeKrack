package com.max.codekrack;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.max.codekrack.databaseutil.DatabaseUtil;
import com.max.codekrack.user.User;

@RestController
@RequestMapping(value="/api")
public class CodeKrackService {

	@Autowired
	Question question;
	
	@Autowired
	User user;
	
	@RequestMapping(value="/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Question[] get() {
		Question[] questions = {new Question(), new Question(), new Question(), new Question(), new Question()};
		return questions;
		
	}
	@RequestMapping(value="/get/language", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Question> getByLanguage(@RequestParam String language) {
		
		return DatabaseUtil.getQuestion2(language);
		
	}
	
	@RequestMapping(value="/addQuestion", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public QuestionService addQuestion(@RequestBody QuestionService qs) {
		
		System.out.println(qs);
		DatabaseUtil.addCode(qs.getLanguage(), qs.getCode(), qs.getAnswer(), qs.getAnswer1(),
				qs.getAnswer2(), qs.getAnswer3(), qs.getAnswer4(), qs.getAnswer5(),
				qs.getQuestion());
		
		return qs;
	}
	

}
