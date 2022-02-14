package com.iAKIN.LanguageApp.model.phrase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "word_tr")
public class WordTr extends Word {

    // @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "word_en_tr",
            joinColumns = @JoinColumn(name = "word_tr_id"),
            inverseJoinColumns = @JoinColumn(name = "word_en_id"))
    private List<WordEn> equal = new ArrayList<>();

    public List<WordEn> getEqual() { return equal; }

    public void setEqual(List<WordEn> equal) { this.equal = equal; }

    @Override
    public List<Phrase> getEquals() { return new ArrayList<>(getEqual()); }
}