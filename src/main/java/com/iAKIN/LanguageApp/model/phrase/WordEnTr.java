package com.iAKIN.LanguageApp.model.phrase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "word_en_tr")
public class WordEnTr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "word_en_id")
    private Integer wordEn;

    @Column(name = "word_tr_id")
    private Integer wordTr;

    public WordEnTr(Integer wen, Integer wtr) {
        wordEn = wen;
        wordTr = wtr;
    }
}