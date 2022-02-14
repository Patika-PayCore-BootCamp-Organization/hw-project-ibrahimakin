package com.iAKIN.LanguageApp.service.impl;

import com.iAKIN.LanguageApp.exception.NotFoundException;
import com.iAKIN.LanguageApp.model.phrase.*;
import com.iAKIN.LanguageApp.repository.SentenceTrRepository;
import com.iAKIN.LanguageApp.repository.WordEnRepository;
import com.iAKIN.LanguageApp.repository.WordTrRepository;
import com.iAKIN.LanguageApp.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhraseServiceImpl implements PhraseService {

    @Autowired
    private WordEnRepository wordEnRepository;
    @Autowired
    private WordTrRepository wordTrRepository;
    @Autowired
    private SentenceTrRepository sentenceTrRepository;

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
        Optional<?> phrase = Optional.empty();
        if (type.equals("sentence")) phrase = sentenceTrRepository.findById(id);
        else if (type.equals("word")) {
            if (lang.equals("tr")) phrase = wordTrRepository.findById(id);
            else phrase = wordEnRepository.findById(id);
        }
        if (phrase.isPresent()) return new PhraseEqual((Phrase) phrase.get());
        else throw new NotFoundException("Phrase");
    }

    @Override
    public boolean addPhrase(String type, String lang, PhraseEqual phrase) {
        if (type.equals("word")) {
            if (lang.equals("tr")) {
                WordTr word = new WordTr();
                word.setValue(phrase.getValue());
                word.setImg(phrase.getImg());
                word.setDef(phrase.getDef());
                List<WordEn> equals = new ArrayList<>();
                for (PhraseEqual equal : phrase.getEquals()) {
                    WordEn w = new WordEn();
                    w.setValue(equal.getValue());
                    w.setImg(equal.getImg());
                    w.setDef(equal.getDef());
                    equals.add(w);
                }
                wordEnRepository.saveAll(equals);
                word.setEqual(equals);
                wordTrRepository.save(word);
                return true;
            } else if (lang.equals("en")) {

            }
        } else if (type.equals("sentence")) {

        }
        return false;
    }
}
