package com.devrezaur.main.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ques_id")
	private Integer quesId;
	private String description;
	private String optionA;
	private String optionB;
	private String optionC;
	//private String optionD;
	private String ans;
	private String chose;
	//private int negativeMarking;

	public Question() {
		super();
	}

	public Question(int quesId, String description, String optionA, String optionB, String optionC ,String ans,String chose) {
		super();
		this.quesId = quesId;
		this.description = description;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		//this.optionD = optionD;
		this.ans = ans;
		this.chose = chose;
		//this.negativeMarking = negativeMarking;
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String title) {
		this.description = description;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
//	public String getOptionD() {
//		return optionD;
//	}
//
//	public void D(String optionD) {
//		this.optionD = optionD;
//	}
	public String getCorrectAnswer() {
		return ans;
	}

	public void setCorrectAnswer(String ans) {
		this.ans = ans;
	}

	public String getChose() {
		return chose;
	}

	public void setChose(String choosed) {
		this.chose = choosed;
	}

	@Override
	public String toString() {
		return "Question [quesId=" + quesId + ", description=" + description + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", ans=" + ans + ", chose=" + chose + "]";
	}

}
