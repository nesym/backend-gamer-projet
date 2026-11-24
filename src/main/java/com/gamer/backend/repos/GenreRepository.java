package com.gamer.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gamer.backend.entities.Genre;

// Spring Data REST cree automatiquement : GET http://localhost:8080/gamers/genres
@RepositoryRestResource(path = "genres", collectionResourceRel = "genres")
@CrossOrigin("http://localhost:4200")
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
