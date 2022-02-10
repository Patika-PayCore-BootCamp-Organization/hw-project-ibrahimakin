package com.iAKIN.LanguageApp.model.phrase;

import javax.persistence.*;

@MappedSuperclass
public abstract class Word implements Phrase {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    @Column(name = "value", length = 50)
    private String value;

    @Column(name = "img", length = 100)
    private String img;

    @Column(name = "def", length = 250)
    private String def;

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }

    public String getImg() { return img; }

    public void setImg(String img) { this.img = img; }

    public String getDef() { return def; }

    public void setDef(String def) { this.def = def; }

    @Override
    public String getQuotes() { return null; }
}