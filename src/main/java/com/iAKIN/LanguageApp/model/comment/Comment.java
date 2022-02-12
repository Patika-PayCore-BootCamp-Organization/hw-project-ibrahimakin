package com.iAKIN.LanguageApp.model.comment;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "comment", length = 250)
    private String comment;

    @Column(name = "phrase_id")
    private Integer phraseId;

    @Column(name = "type")
    private String type;

    @Column(name = "lang")
    private String lang;

    @Column(name = "created")
    private LocalDate created;
}