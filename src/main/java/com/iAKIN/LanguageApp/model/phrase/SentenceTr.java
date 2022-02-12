package com.iAKIN.LanguageApp.model.phrase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sentence_tr")
public class SentenceTr extends Sentence {

    @ManyToMany
    @JoinTable(
            name = "sentence_en_tr",
            joinColumns = @JoinColumn(name = "sentence_tr_id"),
            inverseJoinColumns = @JoinColumn(name = "sentence_en_id"))
    private List<SentenceEn> equal;

    public List<SentenceEn> getEqual() { return equal; }

    public void setEqual(List<SentenceEn> equal) { this.equal = equal; }

    @Override
    public List<Phrase> getEquals() { return new ArrayList<>(getEqual()); }
}