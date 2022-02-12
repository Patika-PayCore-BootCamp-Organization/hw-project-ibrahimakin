package com.iAKIN.LanguageApp.repository;

import com.iAKIN.LanguageApp.model.phrase.WordTr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordTrRepository extends JpaRepository<WordTr, Integer> {
//    @Query("select wtr.id, wtr.value, wtr.img, wtr.def, wen as ens from word_tr as wtr INNER JOIN word_en_tr as wentr ON wtr.id = wentr.word_tr_id INNER JOIN word_en as wen ON wen.id = wentr.word_en_id order by random()")
//    List<WordTr> findRandomWords(Pageable pageable);

//    @Query(value = "SELECT * FROM word_tr " +
//            "LEFT JOIN word_en_tr ON word_tr.id = word_en_tr.word_tr_id " +
//            "LEFT JOIN word_en ON word_en.id = word_en_tr.word_en_id", nativeQuery = true)
//    List<WordTr> findAllWordTr();
}