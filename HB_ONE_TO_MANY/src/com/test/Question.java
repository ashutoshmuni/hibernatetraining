package com.test;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Question {

	private Long id;
	private String question;
	
	private Set<Answer> answers;
}
