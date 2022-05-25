package com.amine.tvshows.entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class TvShow {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idTvShow;

@NotNull
@Size (min = 4,max = 15)
private String nomTvShow;

public Genre getGenre() {
	return genre;
}
public void setGenre(Genre genre) {
	this.genre = genre;
}

@Min(value = 10)
@Max(value = 10000)
private int saisonTvShow;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date dateCreation;

@ManyToOne
private Genre genre;
public TvShow() {
super();
}
public TvShow(String nomTvShow, int saisonTvShow, Date dateCreation) {
super();
this.nomTvShow = nomTvShow;
this.saisonTvShow = saisonTvShow;

this.dateCreation = dateCreation;
}


public Long getIdTvShow() {
	return idTvShow;
}
public void setIdTvShow(Long idTvShow) {
	this.idTvShow = idTvShow;
}
public String getNomTvShow() {
	return nomTvShow;
}
public void setNomTvShow(String nomTvShow) {
	this.nomTvShow = nomTvShow;
}
public int getSaisonTvShow() {
return saisonTvShow;
}
public void setSaisonTvShow(int saisonTvShow) {
this.saisonTvShow = saisonTvShow;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
@Override
public String toString() {
	return "TvShow [idTvShow=" + idTvShow + ", nomTvShow=" + nomTvShow + ", saisonTvShow=" + saisonTvShow
			+
			 "dateCreation=" + dateCreation + ", genre=" + genre + "]";

}
}


