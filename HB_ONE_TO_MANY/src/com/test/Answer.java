package com.test;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Answer implements Serializable {

	private Long id;
	private String answer;
}
