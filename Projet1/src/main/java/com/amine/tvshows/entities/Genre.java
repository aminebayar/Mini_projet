package com.amine.tvshows.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
public class Genre {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idGenre;
private String nomGenre;
private String descriptionGenre;
@JsonIgnore
@OneToMany(mappedBy = "genre")
private List<TvShow> tvshows;
public Genre() {}
public Genre(String nomGenre, String descriptionGenre, List<TvShow> tvshows) 
{
super();
this.nomGenre = nomGenre;
this.descriptionGenre = descriptionGenre;
this.tvshows = tvshows;
}
public Long getIdGenre() {
return idGenre;
}
public void setIdGenre(Long idGenre) {
this.idGenre = idGenre;
}
public String getNomGenre() {
return nomGenre;
}
public void setNomGenre(String nomGenre) {
this.nomGenre = nomGenre;
}
public String getDescriptionGenre() {
return descriptionGenre;
}
public void setDescriptionGenre(String descriptionGenre) {
this.descriptionGenre = descriptionGenre;
}
public List<TvShow> getTvShows() {
return tvshows;
}
public void setTvShows(List<TvShow> tvshows) {
this.tvshows = tvshows;
}
@Override
public String toString() {
	return "Categorie [idGenre=" + idGenre + ", nomGenre=" + nomGenre + ", descriptionGenre=" + descriptionGenre + "]";
}
}