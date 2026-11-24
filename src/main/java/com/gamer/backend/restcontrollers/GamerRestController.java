package com.gamer.backend.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gamer.backend.entities.Gamer;
import com.gamer.backend.repos.GamerRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class GamerRestController {

    @Autowired
    private GamerRepository gamerRepository;

    // GET http://localhost:8080/gamers/api
    @GetMapping
    public List<Gamer> getAllGamers() {
        return gamerRepository.findAll();
    }

    // GET http://localhost:8080/gamers/api/2
    @GetMapping("/{id}")
    public Gamer getGamerById(@PathVariable("id") Long id) {
        return gamerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gamer introuvable"));
    }

    // POST http://localhost:8080/gamers/api
    @PostMapping
    public Gamer createGamer(@RequestBody Gamer gamer) {
        gamer.setIdGamer(null); // l'id est genere par la base de donnees
        return gamerRepository.save(gamer);
    }

    // PUT http://localhost:8080/gamers/api
    @PutMapping
    public Gamer updateGamer(@RequestBody Gamer gamer) {
        return gamerRepository.save(gamer);
    }

    // DELETE http://localhost:8080/gamers/api/5
    @DeleteMapping("/{id}")
    public void deleteGamer(@PathVariable("id") Long id) {
        gamerRepository.deleteById(id);
    }

    // GET http://localhost:8080/gamers/api/gen/1  (gamers d'un genre)
    @GetMapping("/gen/{idGenre}")
    public List<Gamer> getGamersByGenre(@PathVariable("idGenre") Long idGenre) {
        return gamerRepository.findByGenreIdGenre(idGenre);
    }
}
