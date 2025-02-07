package com.devrezaur.main.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;  // Adding a proper primary key

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Question> questions; // Establishing a relationship

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
