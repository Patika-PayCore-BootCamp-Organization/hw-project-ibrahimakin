package com.iAKIN.LanguageApp.model.phrase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "word_en")
public class WordEn extends Word {
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "word_en_tr",
            joinColumns = @JoinColumn(name = "word_tr_id"),
            inverseJoinColumns = @JoinColumn(name = "word_en_id"))
    private List<WordTr> equal;

    public List<WordTr> getEqual() { return equal; }

    public void setEqual(List<WordTr> equal) { this.equal = equal; }

    @Override
    public List<Phrase> getEquals() { return new ArrayList<>(getEqual()); }
}