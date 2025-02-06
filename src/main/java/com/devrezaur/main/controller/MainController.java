package com.devrezaur.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.devrezaur.main.model.Question;
import com.devrezaur.main.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.devrezaur.main.model.QuestionForm;
import com.devrezaur.main.model.Result;
import com.devrezaur.main.service.QuizService;

@Controller
public class MainController {

	@Autowired
	QuizService qService;
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

	@PostMapping("/saveQuestions")
	public String saveQuestions(
			@RequestParam(value = "question[]", required = false) List<String> questions,
			@RequestParam(value = "opt1[]", required = false) List<String> opt1,
			@RequestParam(value = "opt2[]", required = false) List<String> opt2,
			@RequestParam(value = "opt3[]", required = false) List<String> opt3,
			@RequestParam(value = "correctAns[]", required = false) List<String> correctAns,
			Model model) {

		if (questions == null || opt1 == null || opt2 == null || opt3 == null || correctAns == null) {
			System.out.println("Missing parameters!");
			return "error"; // return error view or something else
		}

		List<Question> questionList = new ArrayList<>();

		for (int i = 0; i < questions.size(); i++) {
			Question question = new Question();
			question.setDescription(questions.get(i));
			question.setOptionA(opt1.get(i));
			question.setOptionB(opt2.get(i));
			question.setOptionC(opt3.get(i));
			question.setCorrectAnswer(correctAns.get(i));

			questionList.add(question);
		}

		// Check if repository is injected
		System.out.println("Saving questions to the database...");

		for (Question question : questionList) {
			qRepo.save(question);
		}

		model.addAttribute("message", "Questions saved successfully!");
		return "questionsSaved.html";
	}




}
