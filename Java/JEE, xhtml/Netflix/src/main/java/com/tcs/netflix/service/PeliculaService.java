package com.tcs.netflix.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.tcs.netflix.dao.PeliculaDao;
import com.tcs.netflix.entity.VideosPeliculas;

@RequestScoped
public class PeliculaService {
	@Inject
	private PeliculaDao peliculaDao;
	@Inject
	private Event<VideosPeliculas> peliculaEvento;
	@Inject
	private List<VideosPeliculas> listaPeliculas;

	public void crearPelicula(VideosPeliculas pelicula) {
		peliculaDao.guardar(pelicula);
		peliculaEvento.fire(pelicula);
	}

	public VideosPeliculas buscarPeliculaId(int id) {
		return peliculaDao.bucar(id);
	}

	public void eliminarVideo(VideosPeliculas pelicula) {
	peliculaDao.borrar(pelicula);
	peliculaEvento.fire(pelicula);
	}

	public List<VideosPeliculas> buscarPeliculaTipo(String tipo) {
		List<VideosPeliculas> videoFiltro = new ArrayList<VideosPeliculas>();
		listaPeliculas = peliculaDao.buscarTodos();
		for (VideosPeliculas pelicula : listaPeliculas) {
			if (pelicula.getClasificacionVideo().getLabel().equals(tipo)) {
				videoFiltro.add(pelicula);
			}
		}

		return videoFiltro;
	}

}
