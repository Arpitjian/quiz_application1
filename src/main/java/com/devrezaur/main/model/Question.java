package com.devrezaur.main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questionstable")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ques_id;

	@NotNull(message = "Description cannot be null")
	private String description;

	private String option_a;
	private String option_b;
	private String option_c;
	private String correct_ans;
	private String chosen;

	// Getters and Setters
	public Integer getQuesId() {
		return ques_id;
	}

	public void setQuesId(Integer ques_id) {
		this.ques_id = ques_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOptionA() {
		return option_a;
	}

	public void setOptionA(String optionA) {
		this.option_a = optionA;
	}

	public String getOptionB() {
		return option_b;
	}

	public void setOptionB(String optionB) {
		this.option_b = optionB;
	}

	public String getOptionC() {
		return option_c;
	}

	public void setOptionC(String optionC) {
		this.option_c = optionC;
	}

	public String getCorrectAnswer() {
		return correct_ans;
	}

	public void setCorrectAnswer(String correct_ans) {
		this.correct_ans = correct_ans;
	}

	public String getChose() {
		return chosen;
	}

	public void setChose(String chosen) {
		this.chosen = chosen;
	}

	@Override
	public String toString() {
		return "Question [ques_id=" + ques_id + ", description=" + description + ", option_a=" + option_a + ", option_b=" + option_b
				+ ", option_c=" + option_c + ", correct_ans=" + correct_ans + ", chosen=" + chosen + "]";
	}
}
