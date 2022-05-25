package com.amine.tvshows.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.amine.tvshows.entities.Genre;
import com.amine.tvshows.entities.TvShow;
public interface TvShowService {
TvShow saveTvShow(TvShow p);
TvShow updateTvShow(TvShow p);
void deleteTvShow(TvShow p);
 void deleteTvShowById(Long id);
TvShow getTvShow(Long id);
List<TvShow> getAllTvShows();
Page<TvShow> getAllTvShowsParPage(int page, int size);
List<TvShow> findByNomTvShow(String nom);
List<TvShow> findByNomTvShowContains(String nom);
List<TvShow> findByNomSaison (String nom, Double saison);
List<TvShow> findByGenre (Genre genre);
List<TvShow> findByGenreIdGenre(Long id);
List<TvShow> findByOrderByNomTvShowAsc();
List<TvShow> trierTvShowsNomsSaison();
}