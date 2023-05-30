package com.max.codekrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.max.codekrack.databaseutil.DatabaseUtil;

@SpringBootApplication
@ComponentScan
public class CodekrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodekrackApplication.class, args);
		
	}

}
 