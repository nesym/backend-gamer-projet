package com.gamer.backend.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamer.backend.entities.Genre;
import com.gamer.backend.repos.GenreRepository;

// La LISTE des genres vient de Spring Data REST (GET /gamers/genres).
// Ici on ajoute seulement la creation et la modification.
@RestController
@RequestMapping("/api/genres")
@CrossOrigin("http://localhost:4200")
public class GenreRestController {

    @Autowired
    private GenreRepository genreRepository;

    // POST http://localhost:8080/gamers/api/genres
    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        genre.setIdGenre(null);
        return genreRepository.save(genre);
    }

    // PUT http://localhost:8080/gamers/api/genres
    @PutMapping
    public Genre updateGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }
}
