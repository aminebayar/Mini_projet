package com.amine.tvshows.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.amine.tvshows.entities.Genre;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}