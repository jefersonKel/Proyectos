package com.tcs.netflix.producer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcs.netflix.dao.PeliculaDao;
import com.tcs.netflix.entity.VideosPeliculas;

@RequestScoped
public class PeliculaProducer {
	@Inject
	private PeliculaDao peliculaDao;
	@Inject
	private List<VideosPeliculas> listaPeliculas;

	@PostConstruct
	public void obtenerPeliculas() {
		listaPeliculas = peliculaDao.buscarTodos();
	}
	@Produces
	@Named
	public List<VideosPeliculas> getListaPeliculas() {
		return listaPeliculas;
	}
	
	public void cuandoMiembroListaEsCambiado(@Observes(notifyObserver = Reception.IF_EXISTS) final VideosPeliculas miembro) {
		obtenerPeliculas();

	}
}
