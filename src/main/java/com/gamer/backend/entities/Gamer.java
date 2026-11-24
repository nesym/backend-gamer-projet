package com.gamer.backend.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Gamer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGamer;

    private String pseudoGamer;

    private Double scoreGamer;

    private LocalDate dateInscription;

    @ManyToOne
    private Genre genre;

    public Gamer() {
    }

    public Gamer(Long idGamer, String pseudoGamer, Double scoreGamer, LocalDate dateInscription, Genre genre) {
        this.idGamer = idGamer;
        this.pseudoGamer = pseudoGamer;
        this.scoreGamer = scoreGamer;
        this.dateInscription = dateInscription;
        this.genre = genre;
    }

    public Long getIdGamer() {
        return idGamer;
    }

    public void setIdGamer(Long idGamer) {
        this.idGamer = idGamer;
    }

    public String getPseudoGamer() {
        return pseudoGamer;
    }

    public void setPseudoGamer(String pseudoGamer) {
        this.pseudoGamer = pseudoGamer;
    }

    public Double getScoreGamer() {
        return scoreGamer;
    }

    public void setScoreGamer(Double scoreGamer) {
        this.scoreGamer = scoreGamer;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
