package com.amine.tvshows.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.amine.tvshows.entities.Genre;
import com.amine.tvshows.entities.TvShow;
import com.amine.tvshows.repos.TvShowRepository;
@Service
public class TvShowServiceImpl implements TvShowService {
@Autowired
TvShowRepository tvshowRepository;
@Override
public TvShow saveTvShow(TvShow p) {
	return tvshowRepository.save(p);
	}
	@Override
	public TvShow updateTvShow(TvShow p) {
	return tvshowRepository.save(p);
	}
	@Override
	public void deleteTvShow(TvShow p) {
		tvshowRepository.delete(p);
	}
	 @Override
	public void deleteTvShowById(Long id) {
		 tvshowRepository.deleteById(id);
	}
	@Override
	public TvShow getTvShow(Long id) {
	return tvshowRepository.findById(id).get();
	}
	@Override
	public List<TvShow> getAllTvShows() {
	return tvshowRepository.findAll();
	}
	@Override
	public Page<TvShow> getAllTvShowsParPage(int page, int size) {
		return tvshowRepository.findAll(PageRequest.of(page, size));

	}
	@Override
	public List<TvShow> findByNomTvShow(String nom) {
	return tvshowRepository.findByNomTvShow(nom);
	}
	@Override
	public List<TvShow> findByNomTvShowContains(String nom) {
	return tvshowRepository.findByNomTvShowContains(nom);
	}
	@Override
	public List<TvShow> findByNomSaison(String nom, Double saison) {
		return tvshowRepository.findByNomSaison(nom, saison);
	}
	@Override
	public List<TvShow> findByGenre(Genre genre) {
	return tvshowRepository.findByGenre(genre);
	}
	@Override
	public List<TvShow> findByGenreIdGenre(Long id) {
	return tvshowRepository.findByGenreIdGenre(id);
	}
	@Override
	public List<TvShow> findByOrderByNomTvShowAsc() {
	return tvshowRepository.findByOrderByNomTvShowAsc();
	}
	@Override
	public List<TvShow> trierTvShowsNomsSaison() {
	return tvshowRepository.trierTvShowsNomsSaison();
	}
}