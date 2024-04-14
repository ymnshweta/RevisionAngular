package com.jbk.RevisionAngular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan("com")
@EntityScan("com.jbk.RevisionAngular")
public class RevisionAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevisionAngularApplication.class, args);
		int length=new String().length();//when we want to run multiple method that time u creat this reference or call the length method
		System.out.println("Run project............");
	}

}
