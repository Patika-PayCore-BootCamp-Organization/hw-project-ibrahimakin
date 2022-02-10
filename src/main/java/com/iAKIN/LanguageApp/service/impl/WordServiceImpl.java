package com.iAKIN.LanguageApp.service.impl;

import com.iAKIN.LanguageApp.model.phrase.WordEn;
import com.iAKIN.LanguageApp.model.phrase.WordTr;
import com.iAKIN.LanguageApp.repository.WordEnRepository;
import com.iAKIN.LanguageApp.repository.WordTrRepository;
import com.iAKIN.LanguageApp.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordEnRepository wordEnRepository;
    @Autowired
    private WordTrRepository wordTrRepository;

    @Override
    public List<WordEn> getAllEnWords() { return wordEnRepository.findAll(); }

    @Override
    public List<WordTr> getAllTrWords() { return wordTrRepository.findAll(); }
}
