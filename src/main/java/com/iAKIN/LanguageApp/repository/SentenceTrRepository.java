package com.iAKIN.LanguageApp.repository;

import com.iAKIN.LanguageApp.model.phrase.SentenceTr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentenceTrRepository extends JpaRepository<SentenceTr, Integer> { }