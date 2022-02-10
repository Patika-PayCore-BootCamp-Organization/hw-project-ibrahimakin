package com.iAKIN.LanguageApp.model.question;

import com.iAKIN.LanguageApp.model.phrase.Phrase;
import lombok.Data;

import java.util.*;

@Data
public class Choosing implements Question {
    private List<Map<String, Object>> options;
    private String question;
    private String variant;
    private String quotes;
    private String type;
    private String img;
    private Integer id;

    public Choosing(List<Phrase> phrases, String type, String variant) {
        Random rand = new Random();
        this.type = type;
        this.variant = variant;
        int n = phrases.size();
        int r = rand.nextInt(n);
        this.id = phrases.get(r).getId();
        this.img = phrases.get(r).getImg();
        this.quotes = phrases.get(r).getQuotes();
        this.question = phrases.get(r).getValue();
        this.options = new ArrayList<>();
        for (Phrase phrase : phrases) {
            Map<String, Object> option = new HashMap<>();
            option.put("id", phrase.getId());
            n = phrase.getEquals().size();
            r = rand.nextInt(n);
            option.put("value", phrase.getEquals().get(r).getValue());
            this.options.add(option);
        }
    }
}