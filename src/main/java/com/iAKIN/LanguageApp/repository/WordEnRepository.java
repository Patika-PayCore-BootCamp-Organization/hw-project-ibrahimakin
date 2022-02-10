package com.iAKIN.LanguageApp.repository;

import com.iAKIN.LanguageApp.model.phrase.WordEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordEnRepository extends JpaRepository<WordEn, Integer> { }