package com.gamer.backend;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.gamer.backend.entities.Gamer;
import com.gamer.backend.entities.Genre;
import com.gamer.backend.repos.GamerRepository;
import com.gamer.backend.repos.GenreRepository;

@SpringBootApplication
public class GamerBackendApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GamerRepository gamerRepository;

    public static void main(String[] args) {
        SpringApplication.run(GamerBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Spring Data REST cache les id par defaut : on les expose pour Angular
        repositoryRestConfiguration.exposeIdsFor(Genre.class);

        // Donnees de depart (seulement si la table des genres est vide)
        if (genreRepository.count() == 0) {
            Genre fps = genreRepository.save(new Genre(null, "FPS"));
            Genre rpg = genreRepository.save(new Genre(null, "RPG"));
            Genre sport = genreRepository.save(new Genre(null, "Sport"));
            genreRepository.save(new Genre(null, "Strategie"));

            gamerRepository.save(new Gamer(null, "ShadowWolf", 15200.5, LocalDate.of(2021, 3, 14), fps));
            gamerRepository.save(new Gamer(null, "QueenOfPixels", 830.0, LocalDate.of(2022, 7, 2), rpg));
            gamerRepository.save(new Gamer(null, "mohsen589", 99999.0, LocalDate.of(2020, 11, 20), sport));
        }
    }
}
