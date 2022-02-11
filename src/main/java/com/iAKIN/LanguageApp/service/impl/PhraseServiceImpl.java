package com.iAKIN.LanguageApp.service.impl;

import com.iAKIN.LanguageApp.model.phrase.*;
import com.iAKIN.LanguageApp.repository.SentenceTrRepository;
import com.iAKIN.LanguageApp.repository.WordEnRepository;
import com.iAKIN.LanguageApp.repository.WordEnTrRepository;
import com.iAKIN.LanguageApp.repository.WordTrRepository;
import com.iAKIN.LanguageApp.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PhraseServiceImpl implements PhraseService {

    @Autowired
    private WordEnRepository wordEnRepository;
    @Autowired
    private WordTrRepository wordTrRepository;
    @Autowired
    private SentenceTrRepository sentenceTrRepository;
    @Autowired
    private WordEnTrRepository wordEnTrRepository;

    @Override
    public List<PhraseEqual> getAllPhrases(String type, String lang) {
        if (type.equals("sentence")) {
            return sentenceTrRepository.findAll().stream().map(PhraseEqual::new).collect(Collectors.toList());
        }
        if (lang.equals("tr")) {
            return wordTrRepository.findAll().stream().map(PhraseEqual::new).collect(Collectors.toList());
        }
        return wordEnRepository.findAll().stream().map(PhraseEqual::new).collect(Collectors.toList());
    }

    @Override
    public PhraseEqual getPhrase(String type, String lang, Integer id) {
        if (type.equals("sentence")) {
            return new PhraseEqual(sentenceTrRepository.getById(id));
        }
        if (lang.equals("tr")) { return new PhraseEqual(wordTrRepository.getById(id)); }
        return new PhraseEqual(wordEnRepository.getById(id));
    }

    @Override
    public boolean addPhrase(String type, String lang, PhraseEqual phrase) {
        if (type.equals("word")) {
            if (lang.equals("tr")) {
                WordTr word = new WordTr();
                word.setValue(phrase.getValue());
                word.setImg(phrase.getImg());
                word.setDef(phrase.getDef());
//                List<WordEn> equals = new ArrayList<>();
                WordTr result = wordTrRepository.save(word);
                for (Map<String, Object> equal : phrase.getEquals()) {
                    WordEn w = new WordEn();
                    w.setValue(equal.get("value").toString());
                    if (equal.containsKey("img")) w.setImg(equal.get("img").toString());
                    if (equal.containsKey("def")) w.setDef(equal.get("def").toString());
                    WordEn r = wordEnRepository.save(w);
                    wordEnTrRepository.save(new WordEnTr(r.getId(), result.getId()));
                }
                System.out.println(word.getEqual());
                return result != null;
            } else if (lang.equals("en")) {

            }
        } else if (type.equals("sentence")) {

        }
        return false;
    }
}
