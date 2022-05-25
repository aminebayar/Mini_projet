package com.amine.tvshows.service;

import java.util.List;

import com.amine.tvshows.entities.Genre;


public interface GenreService {

    List <Genre> findAll();
    Genre saveGenre(Genre c);
    Genre updateGenre(Genre c);
    void deleteGenre(Genre c);
     void deleteGenreById(Long id);
     Genre getGenre (Long idGenre);

}