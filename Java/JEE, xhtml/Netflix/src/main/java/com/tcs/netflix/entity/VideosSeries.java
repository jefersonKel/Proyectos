package com.tcs.netflix.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VideosSeries extends Videos {

	private static final long serialVersionUID = 5955498700318137766L;
	private VideosTemporadas temporada;
	private int capitulo;
	@ManyToOne
	@JoinColumn(name = "idSerie")
	private Series serie;

	public VideosTemporadas getTemporada() {
		return temporada;
	}

	public void setTemporada(VideosTemporadas temporada) {
		this.temporada = temporada;
	}

	public int getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	public Series getSerie() {
		return serie;
	}

	public void setSerie(Series serie) {
		this.serie = serie;
	}

}
