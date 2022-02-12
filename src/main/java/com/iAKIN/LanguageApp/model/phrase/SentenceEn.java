package com.iAKIN.LanguageApp.model.phrase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sentence_en")
public class SentenceEn extends Sentence {

    @ManyToMany(mappedBy = "equal")
    private List<SentenceTr> equal;

    public List<SentenceTr> getEqual() { return equal; }

    public void setEqual(List<SentenceTr> equal) { this.equal = equal; }

    @Override
    public List<Phrase> getEquals() { return new ArrayList<>(getEqual()); }
}