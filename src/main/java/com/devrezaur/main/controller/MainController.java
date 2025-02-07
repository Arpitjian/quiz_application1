package com.devrezaur.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.devrezaur.main.model.Question;
import com.devrezaur.main.repository.QuestionRepo;
import com.devrezaur.main.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import com.devrezaur.main.model.QuestionForm;
import com.devrezaur.main.model.Result;
//import com.devrezaur.main.service.QuizService;

@Controller
public class MainController {


	@Autowired
	QuestionRepo qRepo;

	Boolean submitted;

	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}

	@GetMapping("/adminLogin")
	public String score() {

		return "adminLogin.html";
	}


	@GetMapping("/createTestPage")
	public String createTest() {

		return "createTestPage.html";
	}

	@RequestMapping("/inviteExaminee")


		@PostMapping
		public String inviteExaminees() {
			// Process the invitation logic here
			return "inviteExaminee.html"; // Return the name of your Thymeleaf HTML page (e.g., inviteSuccess.html)
		}

	@PostMapping("/saveQuestions")
	public String saveQuestions(
			@RequestParam(value = "question[]", required = false) List<String> questions,
			@RequestParam(value = "opt1[]", required = false) List<String> opt1,
			@RequestParam(value = "opt2[]", required = false) List<String> opt2,
			@RequestParam(value = "opt3[]", required = false) List<String> opt3,
			@RequestParam(value = "correctAns[]", required = false) List<String> correctAns,
			Model model) {

		// Check for missing parameters
		if (questions == null || opt1 == null || opt2 == null || opt3 == null || correctAns == null) {
			System.out.println("Missing parameters!");
			return "error"; // Return error view or something else
		}

		List<Question> questionList = new ArrayList<>();

		for (int i = 0; i < questions.size(); i++) {
			String description = questions.get(i);

			// Ensure description is not null or empty
			if (description == null || description.trim().isEmpty()) {
				System.out.println("Error: Description for question " + (i + 1) + " is null or empty");
				model.addAttribute("message", "Description for question " + (i + 1) + " cannot be null or empty.");
				return "error"; // Return an error page
			}

			Question question = new Question();
			question.setDescription(description);
			question.setOptionA(opt1.get(i));
			question.setOptionB(opt2.get(i));
			question.setOptionC(opt3.get(i));
			question.setCorrectAns(correctAns.get(i));

			// Add question to the list
			questionList.add(question);
		}

		// Save all the questions to the database
		for (Question question : questionList) {
			qRepo.save(question);
		}

		// Add success message to the model
		model.addAttribute("message", "Questions saved successfully!");

		// Redirect to a success page (adjust the return value as needed)
		return "questionsSaved.html";
	}






}
