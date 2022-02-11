package com.iAKIN.LanguageApp.controller;

import com.iAKIN.LanguageApp.model.User;
import com.iAKIN.LanguageApp.model.phrase.PhraseEqual;
import com.iAKIN.LanguageApp.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/")
public class PhraseController {
    @Autowired
    private PhraseService phraseService;

    @GetMapping(value = "/{type}/{lang}")
    public List<PhraseEqual> getAllWords(@PathVariable String type, @PathVariable String lang) { return phraseService.getAllPhrases(type, lang); }

    @GetMapping(value = "/{type}/{lang}/{id}")
    public PhraseEqual getWord(@PathVariable String type, @PathVariable String lang, @PathVariable @Min(1) Integer id) { return phraseService.getPhrase(type, lang, id); }

    @PostMapping(value = "/{type}/{lang}")
    public boolean addWord(@PathVariable String type, @PathVariable String lang, @RequestBody final PhraseEqual phrase) { return phraseService.addPhrase(type, lang, phrase); }
}