package com.devrezaur.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devrezaur.main.model.Question;
import com.devrezaur.main.model.QuestionForm;
import com.devrezaur.main.repository.QuestionRepo;

@Service
public class QuizService {

	// Inject the required repository
	@Autowired
	QuestionRepo qRepo;

	// Variable to store the QuestionForm
	private QuestionForm qForm;

	// Method to get a random selection of questions
	public QuestionForm getQuestions() {
		List<Question> allQues = qRepo.findAll();  // Get all questions from the database
		List<Question> qList = new ArrayList<Question>();  // List to hold randomly selected questions

		Random random = new Random();  // Random number generator

		// Loop to select 5 random questions
		for (int i = 0; i < 5; i++) {
			int rand = random.nextInt(allQues.size());  // Get a random index
			qList.add(allQues.get(rand));  // Add the question at the random index
			allQues.remove(rand);  // Remove the selected question from the list
		}

		// Initialize the QuestionForm and set the random questions
		qForm = new QuestionForm();
		qForm.setQuestions(qList);

		return qForm;  // Return the QuestionForm with the selected questions
	}
}
