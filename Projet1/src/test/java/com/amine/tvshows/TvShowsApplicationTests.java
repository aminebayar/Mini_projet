package com.amine.tvshows;
import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.amine.tvshows.entities.Genre;
import com.amine.tvshows.entities.TvShow;
import com.amine.tvshows.repos.TvShowRepository;
import com.amine.tvshows.service.TvShowService;
@SpringBootTest
class TvShowsApplicationTests {
@Autowired
private TvShowRepository tvshowRepository;

@Autowired
private TvShowService tvshowService;

@Test
public void testCreateTvShow() {
TvShow tvshow = new TvShow("PC Dell",2200,new Date());
tvshowRepository.save(tvshow);
}
@Test
public void testFindTvShow()
{
TvShow p = tvshowRepository.findById(1L).get(); 
System.out.println(p);
}
@Test
public void testUpdateTvShow()
{
TvShow p = tvshowRepository.findById(1L).get();
p.setSaisonTvShow(1000);
tvshowRepository.save(p);
}
@Test
public void testDeleteTvShow()
{
tvshowRepository.deleteById(1L);;
}
 
@Test
public void testListerTousTvShows()
{
List<TvShow> tvshows = tvshowRepository.findAll();
for (TvShow p : tvshows)
{
System.out.println(p);
}
}
@Test
public void testFindByNomTvShowContains()
{
Page<TvShow> tvshows = tvshowService.getAllTvShowsParPage(0,2);
System.out.println(tvshows.getSize());
System.out.println(tvshows.getTotalElements());
System.out.println(tvshows.getTotalPages());
tvshows.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (Produit p : prods.getContent()
{
System.out.println(p);
} */
}
@Test
public void testFindByNomTvShow()
{
List<TvShow> tvshows = tvshowRepository.findByNomTvShow("Clavier");
for (TvShow p : tvshows)
{
System.out.println(p);
}
}
@Test
public void findByNomTvShowContains()
{
List<TvShow> tvshows=tvshowRepository.findByNomTvShowContains("P");
for (TvShow p : tvshows)
{
System.out.println(p);
} }
@Test
public void testfindByNomSaison()
{
List<TvShow> tvshows = tvshowRepository.findByNomSaison("iphone X", 1000.0);
for (TvShow p : tvshows)
{
System.out.println(p);
}
}

@Test
public void testfindByGenre()
{
Genre genre = new Genre();
genre.setIdGenre(1L);
List<TvShow> tvshows = tvshowRepository.findByGenre(genre);
for (TvShow p : tvshows)
{
System.out.println(p);
}
}
@Test
public void findByGenreIdGenre()
{
List<TvShow> tvshows = tvshowRepository.findByGenreIdGenre(1L);
for (TvShow p : tvshows)
{
System.out.println(p);
}
 }
@Test
public void testfindByOrderByNomTvShowAsc()
{
List<TvShow> tvshows = 
tvshowRepository.findByOrderByNomTvShowAsc();
for (TvShow p : tvshows)
{
System.out.println(p);
}
}
@Test
public void testTrierTvShowsNomsSaison()
{
List<TvShow> tvshows = tvshowRepository.trierTvShowsNomsSaison();
for (TvShow p : tvshows)
{
System.out.println(p);
}
}
}
