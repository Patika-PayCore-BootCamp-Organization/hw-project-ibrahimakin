package com.iAKIN.LanguageApp.model.phrase;

import javax.persistence.*;

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

    public String getQuotes() { return quotes; }

    public void setQuotes(String quotes) { this.quotes = quotes; }

    public String getImg() { return img; }

    public void setImg(String img) { this.img = img; }

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
}