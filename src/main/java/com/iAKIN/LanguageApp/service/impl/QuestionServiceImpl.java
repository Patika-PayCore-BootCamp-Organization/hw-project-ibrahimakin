package com.iAKIN.LanguageApp.service.impl;

import com.iAKIN.LanguageApp.model.phrase.Phrase;
import com.iAKIN.LanguageApp.model.phrase.SentenceTr;
import com.iAKIN.LanguageApp.model.phrase.WordTr;
import com.iAKIN.LanguageApp.repository.SentenceTrRepository;
import com.iAKIN.LanguageApp.repository.WordTrRepository;
import com.iAKIN.LanguageApp.model.question.Choosing;
import com.iAKIN.LanguageApp.model.question.Question;
import com.iAKIN.LanguageApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private SentenceTrRepository sentenceTrRepository;
    @Autowired
    private WordTrRepository wordTrRepository;

    @Override
    public Question getRandomQuestion() {
        List<String> types = Arrays.asList("choosing"); // , "matching", "sorting");
        Random rand = new Random();
        String type = types.get(rand.nextInt(types.size()));
        if (type.equals("choosing")) {
            List<String> variants = Arrays.asList("word", "sentence");
            String variant = variants.get(rand.nextInt(variants.size()));
            List<Integer> indexes = new ArrayList<>();
            List<Phrase> allPhrases;
            if (variant.equals("word")) {
                List<WordTr> allWords = wordTrRepository.findAll();
                allPhrases = new ArrayList<>(allWords);
            } else {
                List<SentenceTr> allSentences = sentenceTrRepository.findAll();
                allPhrases = new ArrayList<>(allSentences);
            }
            int n = allPhrases.size();
            int r = rand.nextInt(n);
            for (int i = 0; i < 4; i++) {
                while(indexes.contains(r)){ r = rand.nextInt(n); }
                indexes.add(r);
            }
            List<Phrase> phrases = new ArrayList<>();
            for (int i : indexes) { phrases.add(allPhrases.get(i)); }
            return new Choosing(phrases, type, variant);
        } else if (type.equals("matching")) {

        } else {

        }
        return null;
    }
}
