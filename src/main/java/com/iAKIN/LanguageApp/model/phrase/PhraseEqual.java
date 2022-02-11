package com.iAKIN.LanguageApp.model.phrase;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PhraseEqual {
    @NotEmpty
    private List<Map<String, Object>> equals;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String quotes;
    @NotBlank
    private String value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String img;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String def;
    private Integer id;

    public PhraseEqual(Phrase phrase) {
        equals = new ArrayList<>();
        for (Phrase p : phrase.getEquals()) {
            Map<String, Object> equal = new HashMap<>();
            equal.put("id", p.getId());
            equal.put("value", p.getValue());
            equals.add(equal);
        }
        quotes = phrase.getQuotes();
        value = phrase.getValue();
        img = phrase.getImg();
        def = phrase.getDef();
        id = phrase.getId();
    }

    public PhraseEqual(List<Map<String, Object>> equals, String quotes, String value, String img, String def, Integer id) {
        this.equals = equals;
        this.quotes = quotes;
        this.value = value;
        this.img = img;
        this.def = def;
        this.id = id;
    }

    public Sentence FormatToSentence() {
        return null;
    }

    public Word FormatToWord() {
        return null;
    }
}