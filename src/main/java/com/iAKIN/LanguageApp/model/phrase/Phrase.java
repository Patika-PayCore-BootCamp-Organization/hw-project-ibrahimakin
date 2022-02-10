package com.iAKIN.LanguageApp.model.phrase;

import java.util.List;

public interface Phrase {
    Integer getId();
    String getImg();
    String getValue();
    String getQuotes();
    List<Phrase> getEquals();
}