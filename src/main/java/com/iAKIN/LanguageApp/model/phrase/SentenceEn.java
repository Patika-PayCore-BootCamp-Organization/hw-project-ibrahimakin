package com.iAKIN.LanguageApp.model.phrase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sentence_en")
public class SentenceEn extends Sentence {
    @OneToMany
    @JoinTable(
            name = "sentence_en_tr",
            joinColumns = @JoinColumn(name = "sentence_tr_id"),
            inverseJoinColumns = @JoinColumn(name = "sentence_en_id"))
    private List<SentenceTr> equal;

    public List<SentenceTr> getEqual() { return equal; }

    public void setEqual(List<SentenceTr> equal) { this.equal = equal; }

    @Override
    public List<Phrase> getEquals() {
        List<Phrase> phrases = new ArrayList<>(getEqual());
        return phrases;
    }
}