package com.iAKIN.LanguageApp.controller;

import com.iAKIN.LanguageApp.model.question.Question;
import com.iAKIN.LanguageApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "/random")
    public Question getRandomQuestion() { return questionService.getRandomQuestion(); }
}
