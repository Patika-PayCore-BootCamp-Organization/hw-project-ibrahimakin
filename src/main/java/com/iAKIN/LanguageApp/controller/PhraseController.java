package com.iAKIN.LanguageApp.controller;

import com.iAKIN.LanguageApp.model.phrase.PhraseEqual;
import com.iAKIN.LanguageApp.service.PhraseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor // instead of @Autowired
@RequestMapping("/phrase")
public class PhraseController {
    // @Autowired
    private final PhraseService phraseService;

    @GetMapping(value = "/{type}/{lang}")
    public List<PhraseEqual> getAllPhrases(@PathVariable String type, @PathVariable String lang) { return phraseService.getAllPhrases(type, lang); }

    @GetMapping(value = "/{type}/{lang}/{id}")
    public PhraseEqual getPhrase(@PathVariable String type, @PathVariable String lang, @PathVariable @Min(0) Integer id) { return phraseService.getPhrase(type, lang, id); }

    @PostMapping(value = "/{type}/{lang}")
    public boolean addPhrase(@PathVariable String type, @PathVariable String lang, @Valid @RequestBody final PhraseEqual phrase) { return phraseService.addPhrase(type, lang, phrase); }
}