package com.iAKIN.LanguageApp.repository;

import com.iAKIN.LanguageApp.model.phrase.WordEnTr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordEnTrRepository extends JpaRepository<WordEnTr, Integer> { }