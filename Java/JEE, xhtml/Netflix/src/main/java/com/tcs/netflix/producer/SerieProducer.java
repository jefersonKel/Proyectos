package com.tcs.netflix.producer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcs.netflix.dao.SerieDao;
import com.tcs.netflix.entity.Series;

@RequestScoped
public class SerieProducer {
	@Inject
	private SerieDao serieDao;
	@Inject
	private List<Series> listaSerie;

	@PostConstruct
	public void obtenerSeries() {
		listaSerie = serieDao.buscarTodos();
	}

	@Produces
	@Named
	public List<Series> getListaSerie()  {
		return listaSerie;
	}

	public void cuandoMiembroListaEsCambiado(@Observes(notifyObserver = Reception.IF_EXISTS) final Series miembro) {
		obtenerSeries();

	}
}
