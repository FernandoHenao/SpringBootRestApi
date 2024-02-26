package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.model.Film;
import com.example.demo.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/films")
public class FilmController {

    private FilmService filmService;

    // build create  REST API
    @PostMapping("/save")
    public ResponseEntity<Film> createFilm(@RequestBody Film film){
        Film savedFilm = filmService.createFilm(film);
        return new ResponseEntity<>(savedFilm, HttpStatus.CREATED);
    }

    // build get film by id REST API
    // http://localhost:8080/api/films/1
    @GetMapping("/findById/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long filmId){
        Film film = filmService.getFilmById(filmId);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    // Build Get All Films REST API
    // http://localhost:8080/api/films
    @GetMapping("/findAll")
    public ResponseEntity<List<Film>> getAllFilms(){
        List<Film> films = filmService.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    // Build Update Film REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/films/1
    public ResponseEntity<Film> updateFilm(@PathVariable("id") Long filmId,
                                                   @RequestBody Film film){
        film.setFilm_id(filmId);
        Film updatedFilm = filmService.updateFilm(film);
        return new ResponseEntity<>(updatedFilm, HttpStatus.OK);
    }

    // Build Delete Film REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable("id") Long filmId){
        filmService.deleteFilm(filmId);
        return new ResponseEntity<>("Film successfully deleted!", HttpStatus.OK);
    }
}