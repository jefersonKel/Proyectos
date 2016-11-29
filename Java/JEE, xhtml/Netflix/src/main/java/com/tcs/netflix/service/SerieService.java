package com.tcs.netflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.tcs.netflix.dao.SerieDao;
import com.tcs.netflix.entity.Series;

@Stateless
public class SerieService {
	@Inject
	private SerieDao serieDao;
	@Inject
	private Event<Series> serieEvento;
	@Inject
	private Logger log;
	@Inject
	private List<Series> listaSerie;

	public void crerSerie(Series serie) {
		log.info("Se Gurda Serie:" + serie.getNombreSerie());
		serieDao.guardar(serie);
		serieEvento.fire(serie);
	}

	public void eliminarSerie(Series serie) {
		log.info("Se Elimina Serie:" + serie.getNombreSerie());
		serieDao.borrar(serie);
		serieEvento.fire(serie);
	}

	public Series buscarSerieId(int id) {
		return serieDao.bucar(id);
	}

	public List<Series> buscarSerieTipo(String tipo) {
		List<Series> videoFiltro = new ArrayList<Series>();
		listaSerie = serieDao.buscarTodos();
		for (Series serie : listaSerie) {
			if (serie.getTipoVideo().getLabel().equals(tipo)) {
				videoFiltro.add(serie);
			}
		}
		return videoFiltro;
	}

}
