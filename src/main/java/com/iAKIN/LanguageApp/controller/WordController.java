package com.iAKIN.LanguageApp.controller;

import com.iAKIN.LanguageApp.model.phrase.WordEn;
import com.iAKIN.LanguageApp.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping(value = "/en/all")
    public List<WordEn> getAllEnWords() { return wordService.getAllEnWords(); }

//    @GetMapping(value = "/tr/all")
//    public List<WordTr> getAllTrWords() { return wordService.getAllTrWords(); }
}
