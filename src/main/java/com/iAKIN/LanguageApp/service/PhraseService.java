package com.iAKIN.LanguageApp.service;

import com.iAKIN.LanguageApp.model.phrase.PhraseEqual;

import java.util.List;

public interface PhraseService {
    List<PhraseEqual> getAllPhrases(String type, String lang);
    PhraseEqual getPhrase(String type, String lang, Integer id);
    boolean addPhrase(String type, String lang, PhraseEqual phrase);
}
