package com.iAKIN.LanguageApp.model.phrase;

import lombok.*;
import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Sentence implements Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "value", length = 250)
    private String value;

    @Column(name = "img", length = 100)
    private String img;

    @Column(name = "quotes", length = 50)
    private String quotes;

    @Override
    public String getDef() { return null; }
}