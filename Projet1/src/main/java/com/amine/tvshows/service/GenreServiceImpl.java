package com.amine.tvshows.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.tvshows.entities.Genre;
import com.amine.tvshows.repos.GenreRepository;


@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository GenreRepository;

    @Override
    public List <Genre> findAll() {
        return GenreRepository.findAll();
    }

	@Override
	public Genre saveGenre(Genre c) {
		return GenreRepository.save(c);
	}

	@Override
	public Genre updateGenre(Genre c) {
		return GenreRepository.save(c);
	}

	@Override
	public void deleteGenre(Genre c) {
		GenreRepository.delete(c);
	}

	@Override
	public void deleteGenreById(Long idGenre) {
		GenreRepository.deleteById(idGenre);
	}

	@Override
	public Genre getGenre(Long idGenre) {
		return GenreRepository.findById(idGenre).get();
	}

   
}