package com.iAKIN.LanguageApp.model.phrase;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class PhraseEqual {
    @NotEmpty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<@Valid PhraseEqual> equals;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String quotes;
    @NotBlank(message = "Value can not be null")
    private String value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String img;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String def;
    private Integer id;

    public PhraseEqual(Phrase phrase) {
        equals = new ArrayList<>();
        for (Phrase p : phrase.getEquals()) {
            PhraseEqual equal = new PhraseEqual();
            equal.setValue(p.getValue());
            equal.setId(p.getId());
            equals.add(equal);
        }
        quotes = phrase.getQuotes();
        value = phrase.getValue();
        img = phrase.getImg();
        def = phrase.getDef();
        id = phrase.getId();
    }
}