package com.example.demo.service;

import com.example.demo.model.Film;
import java.util.List;

public interface FilmService {
    Film createFilm(Film film);

    Film getFilmById(Long filmId);

    List<Film> getAllFilms();

    Film updateFilm(Film film);

    void deleteFilm(Long filmId);
}