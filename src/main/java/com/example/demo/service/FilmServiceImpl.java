package com.example.demo.service;

import lombok.AllArgsConstructor;
import com.example.demo.model.Film;
import com.example.demo.repository.FilmRepository;
import com.example.demo.service.FilmService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;

    @Override
    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film getFilmById(Long filmId) {
        Optional<Film> optionalFilm = filmRepository.findById(filmId);
        return optionalFilm.get();
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film updateFilm(Film film) {
        Film existingFilm = filmRepository.findById(film.getFilm_id()).get();
        existingFilm.setRating(film.getRating());
        existingFilm.setRentalRate(film.getRentalRate());
        existingFilm.setDescription(film.getDescription());
        Film updatedFilm= filmRepository.save(existingFilm);
        return updatedFilm;
    }

    @Override
    public void deleteFilm(Long filmId) {
        filmRepository.deleteById(filmId);
    }
}