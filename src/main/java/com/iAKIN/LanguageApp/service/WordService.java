package com.iAKIN.LanguageApp.service;

import com.iAKIN.LanguageApp.model.phrase.WordEn;
import com.iAKIN.LanguageApp.model.phrase.WordTr;

import java.util.List;

public interface WordService {
    List<WordEn> getAllEnWords();
    List<WordTr> getAllTrWords();
}
