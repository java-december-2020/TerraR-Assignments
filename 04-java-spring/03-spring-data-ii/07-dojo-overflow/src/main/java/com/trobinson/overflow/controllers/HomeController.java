package com.trobinson.overflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trobinson.overflow.models.Answer;
import com.trobinson.overflow.models.Question;
import com.trobinson.overflow.models.QuestionTag;
import com.trobinson.overflow.services.AppService;


@Controller
public class HomeController {

	@Autowired
	private AppService aService;
	
	// Landing page
	@GetMapping("/questions")
	public String landing(Model viewModel) {
		List<Question> questions = aService.findAllQuestions();
		viewModel.addAttribute("question", questions);
		return "index.jsp";
	}
	
	// Display question
	@GetMapping("/questions/new")
	public String displayFormQuestion(@ModelAttribute("questionTag") QuestionTag questionTag) {
		return "question.jsp";
	}
	   
	// Process question
	@PostMapping("/questions/new")
	public String processFormQuestion(@Valid @ModelAttribute("questionTag") QuestionTag questionTag, BindingResult result) {
		if (result.hasErrors()) {
			return "question.jsp";
		} else {
			aService.createQuestionTag(questionTag);
			return "redirect:/questions";
		}
	}
	
	// Display answer
	@GetMapping("/questions/{id}")
	public String displayFormAnswer(@PathVariable("id") Long questionId, @ModelAttribute("answer") Answer answer, Model viewModel) {
		Question question = aService.findOneQuestion(questionId);
		List<Answer> answers = aService.findOneQuestion(questionId).getAnswer();
		viewModel.addAttribute("answers", answers);
		viewModel.addAttribute("question", question);
		return "answer.jsp";
	}

	// Process answer
	@PostMapping("/questions/{id}")
	public String processFormAnswer(@PathVariable("id") Long questionId, @Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			Question question = aService.findOneQuestion(questionId);
			List<Answer> answers = aService.findOneQuestion(questionId).getAnswer();
			viewModel.addAttribute("answers", answers);
			viewModel.addAttribute("question", question);
			return "answer.jsp";
		} else {
		aService.createAnswer(answer, questionId);
		return "redirect:/questions";
		}
	}
	
}