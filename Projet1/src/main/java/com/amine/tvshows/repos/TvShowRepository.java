package com.amine.tvshows.repos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amine.tvshows.entities.Genre;
import com.amine.tvshows.entities.TvShow;
@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {
	List<TvShow> findByNomTvShow(String nom);
	 List<TvShow> findByNomTvShowContains(String nom);
	 @Query("select p from TvShow p where p.nomTvShow like %:nom and p.saisonTvShow > :saison")
	 List<TvShow> findByNomSaison(@Param("nom") String nom,@Param("saison") Double saison);
	 @Query("select p from TvShow p where p.genre = ?1")
	 List<TvShow> findByGenre (Genre genre);
	 List<TvShow> findByGenreIdGenre(Long id);
	 List<TvShow> findByOrderByNomTvShowAsc();
	 @Query("select p from TvShow p order by p.nomTvShow ASC, p.saisonTvShow DESC")
	 List<TvShow> trierTvShowsNomsSaison();
}