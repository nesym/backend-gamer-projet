package com.gamer.backend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gamer.backend.entities.Gamer;

// exported = false : les gamers passent par notre controller, pas par Spring Data REST
@RepositoryRestResource(exported = false)
public interface GamerRepository extends JpaRepository<Gamer, Long> {

    // Spring genere la requete tout seul a partir du nom : gamer.genre.idGenre = ?
    List<Gamer> findByGenreIdGenre(Long idGenre);
}
