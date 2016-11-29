package com.tcs.netflix.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.tcs.netflix.entity.Series;
import com.tcs.netflix.entity.VideosPeliculas;

@Singleton
@Startup
public class GestorCompras implements Serializable {

	private static final long serialVersionUID = 3114307289461223644L;
	private List<VideosPeliculas> listaCompraPelicula;
	private List<Series> listaCompraSerie;
	private int totalValorPelicula;
	private int totalValorSerie;

	@PostConstruct
	public void iniciarCompra() {
		this.listaCompraPelicula = new ArrayList<VideosPeliculas>();
		this.listaCompraSerie = new ArrayList<Series>();
		this.totalValorPelicula = 0;
		this.totalValorSerie = 0;
	}

	public void agregarSerie(Series serie) {
		this.listaCompraSerie.add(serie);
		this.totalValorSerie = this.totalValorSerie + serie.getPrecio();
	}
	public void eliminarSerie(Series serie) {
		this.listaCompraSerie.remove(serie);
		this.totalValorSerie = this.totalValorSerie - serie.getPrecio();
	}


	public void agregarPelicula(VideosPeliculas pelicula) {
		this.listaCompraPelicula.add(pelicula);
		this.totalValorPelicula = this.totalValorPelicula + pelicula.getPrecio();
	}
	
	public void eliminarPelicula(VideosPeliculas pelicula) {
		this.listaCompraPelicula.remove(pelicula);
		this.totalValorPelicula = this.totalValorPelicula - pelicula.getPrecio();
	}

	public List<Series> getListaCompraSerie() {
		return listaCompraSerie;
	}

	public List<VideosPeliculas> getListaCompraPelicula() {
		return listaCompraPelicula;
	}

	public int getTotalValorSerie() {
		return totalValorSerie;
	}

	public int getTotalValorPelicula() {
		return totalValorPelicula;
	}

}
