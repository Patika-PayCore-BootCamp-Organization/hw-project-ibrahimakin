package com.iAKIN.LanguageApp.model.phrase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "word_en")
public class WordEn extends Word {

    @ManyToMany(mappedBy = "equal")
    private List<WordTr> equal = new ArrayList<>();

    public List<WordTr> getEqual() { return equal; }

    public void setEqual(List<WordTr> equal) { this.equal = equal; }

    @Override
    public List<Phrase> getEquals() { return new ArrayList<>(getEqual()); }
}