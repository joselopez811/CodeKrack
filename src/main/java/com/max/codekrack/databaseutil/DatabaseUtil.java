package com.max.codekrack.databaseutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.max.codekrack.Answer;
import com.max.codekrack.Code;
import com.max.codekrack.Question;

public class DatabaseUtil {
	
	public static int id = 1;

	public static List<Question> getQuestion2(String language) {
		List<Question> questions = new ArrayList<>();

		String sql = "SELECT question_id, question, code,"
				+ " option1, option2, option3, option4, option5, answer_id "
				+ "FROM test.questions WHERE language = '" + language + "'";
		incrementId();
		try {
			Statement statement = DbConnect.connection.createStatement();
			statement.executeQuery(sql);
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int question_id = rs.getInt("question_id");
				String question = rs.getString("question");
				String code = rs.getString("code");
				String opt1 = rs.getString("option1");
				String opt2 = rs.getString("option2");
				String opt3 = rs.getString("option3");
				String opt4 = rs.getString("option4");
				String opt5 = rs.getString("option5");
				int answerId = rs.getInt("answer_id");
				Answer[] answers =  {
						new Answer(1, opt1, answerId),
						new Answer(2, opt2, answerId),
						new Answer(3, opt3, answerId),
						new Answer(4, opt4, answerId),
						new Answer(5, opt5, answerId)
				};
				questions.add(new Question(question_id, question, new Code(code), answers, answerId));
			}
			
			return questions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static String getQuestion() {
		String sql = "SELECT question FROM test.questions WHERE question_id = " + id;
		incrementId();
		try {
			Statement statement = DbConnect.connection.createStatement();
			statement.executeQuery(sql);
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next())
				return rs.getString("question");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static String getCode() {
		String sql = "SELECT code FROM test.questions WHERE question_id = " + id;
		
		try {
			Statement statement = DbConnect.connection.createStatement();
			statement.executeQuery(sql);
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next())
				return rs.getString("code");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Answer[] getAnswers() {
		String sql = "SELECT option1, option2, option3, option4, option5, answer_id "
				+ "FROM test.questions WHERE question_id = " + id;
		Answer[] answers = new Answer[5] ;
		try {
			Statement statement = DbConnect.connection.createStatement();
			statement.executeQuery(sql);
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				answers[0] = new Answer(1, rs.getString("option1"), rs.getInt("answer_id"));				
				answers[1] = new Answer(2, rs.getString("option2"), rs.getInt("answer_id"));				
				answers[2] = new Answer(3, rs.getString("option3"), rs.getInt("answer_id"));				
				answers[3] = new Answer(4, rs.getString("option4"), rs.getInt("answer_id"));				
				answers[4] = new Answer(5,  rs.getString("option5"), rs.getInt("answer_id"));				
			}
			return answers;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void addCode(String language, String code, int answer_id, String option1, String option2, String option3, String option4, String option5, String question ) {
		String sql = "INSERT INTO test.questions "
				+ "(code, answer_id, option1, option2, option3, option4, option5, question, language) "
				+ "VALUES (?,?,?,?,?,?,?,?, ?);";
		// Used PreparedStatement to use allow variables in the sql statement (?) 
		try (PreparedStatement statement = DbConnect.connection.prepareStatement(sql)) {
			statement.setString(1, code);
			statement.setInt(2, answer_id);
			statement.setString(3, option1);
			statement.setString(4, option2);
			statement.setString(5, option3);
			statement.setString(6, option4);
			statement.setString(7, option5);
			statement.setString(8, question);
			statement.setString(9, language);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void incrementId() {
		id++;
		if(id > 5)
			id = 1;
		
		
	}
	public static int getId() {
	
		return id;
	}
}
