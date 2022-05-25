package com.amine.tvshows.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amine.tvshows.entities.Genre;
import com.amine.tvshows.entities.TvShow;
import com.amine.tvshows.service.GenreService;
import com.amine.tvshows.service.TvShowService;
@Controller
public class TvShowController {
@Autowired
TvShowService tvshowService;
@Autowired
GenreService genreService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<Genre> genres = genreService.findAll();
modelMap.addAttribute("genres", genres);
modelMap.addAttribute("tvshow", new TvShow());
modelMap.addAttribute("mode", "new");
return "formTvShow";
}
@RequestMapping("/saveTvShow")
public String saveTvShow(@Valid TvShow tvshow,
BindingResult bindingResult)
{
System.out.println(tvshow);
if (bindingResult.hasErrors()) return "formTvShow";
tvshowService.saveTvShow(tvshow);

return "redirect:/ListeTvShows";
}

@RequestMapping("/showCreateGenre")
public String showCreateGenre(ModelMap modelMap)
{
modelMap.addAttribute("genres", new Genre());
modelMap.addAttribute("mode", "new");
return "formGenre";
}
@RequestMapping("/saveGenre")
public String saveGenre(@ModelAttribute("genre") Genre genre,ModelMap modelMap) throws ParseException 
{
Genre saveGenre = genreService.saveGenre(genre);
return "redirect:/ListeGenre";
}

@RequestMapping("/ListeGenre")
public String listeProduits(ModelMap modelMap)
{
List <Genre> genres = genreService.findAll();
modelMap.addAttribute("genres", genres);
return "ListeGenre";
}

@RequestMapping("/ListeTvShows")
public String listeTvShows(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	List <Genre> genres = genreService.findAll();
	modelMap.addAttribute("genres", genres);
Page<TvShow> tvshows = tvshowService.getAllTvShowsParPage(page, size);
modelMap.addAttribute("tvshows", tvshows);
 modelMap.addAttribute("pages", new int[tvshows.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeTvShows";
}


@RequestMapping("/supprimerTvShow")
public String supprimerTvShow(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
tvshowService.deleteTvShowById(id);
Page<TvShow> tvshows = tvshowService.getAllTvShowsParPage(page, 
size);
modelMap.addAttribute("tvshows", tvshows);
modelMap.addAttribute("pages", new int[tvshows.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeTvShows";
}
@RequestMapping("/supprimerGenre")
public String supprimerGenre(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
genreService.deleteGenreById(id);
List<Genre> genres = genreService.findAll();
modelMap.addAttribute("genres", genres);
return "ListeGenre";
}

@RequestMapping("/modifierTvShow")
public String editerTvShow(@RequestParam("id") Long id,ModelMap modelMap)
{
TvShow p= tvshowService.getTvShow(id);
List<Genre> genres = genreService.findAll();
genres.remove(p.getGenre());
modelMap.addAttribute("genres", genres);
modelMap.addAttribute("tvshow", p);
modelMap.addAttribute("mode", "edit");
return "editerTvShow";
}
@RequestMapping("/updateTvShow")
public String updateTvShow(@ModelAttribute("tvshow") TvShow tvshow,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 tvshow.setDateCreation(dateCreation);
	 
	 tvshowService.updateTvShow(tvshow);
	 List<TvShow> tvshows = tvshowService.getAllTvShows();
	 modelMap.addAttribute("tvshows", tvshows);
	return "listeTvShows";
	}
@RequestMapping("/modifierGenre")
public String editerGenre(@RequestParam("id") Long id,ModelMap modelMap)
{
Genre c= genreService.getGenre(id);
modelMap.addAttribute("genres", c);
modelMap.addAttribute("mode", "edit");
return "formGenre";
}
@RequestMapping("/updateGenre")
public String updateGenre(@ModelAttribute("genre") Genre genre,ModelMap modelMap) throws ParseException {
	genreService.updateGenre(genre);
	 List<Genre> genres = genreService.findAll();
	 modelMap.addAttribute("genres", genres);
	return "ListeGenre";
	}
@RequestMapping("/searchGenre")
public String recherGenre(@RequestParam("genre") Long genre,ModelMap modelMap)
{
	Genre genres = new Genre();
genres.setIdGenre(genre);
List<Genre> genres2 = genreService.findAll();
modelMap.addAttribute("genres", genres2);
List<TvShow> tvshows = tvshowService.findByGenre(genres);
modelMap.addAttribute("tvshows",tvshows);
modelMap.addAttribute("mode", "Searchgenre");
return "listeTvShows";
}
}