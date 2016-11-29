package com.tcs.netflix.producer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcs.netflix.dao.CapitulosSerieDao;
import com.tcs.netflix.entity.VideosSeries;

@RequestScoped
public class CapituloSerieProducer {

	@Inject
	private CapitulosSerieDao capitulosSerieDao;
	@Inject
	private List<VideosSeries> listaCapitulosSeries;

	@PostConstruct
	public void obtenerCapitulosSeries() {
		listaCapitulosSeries = capitulosSerieDao.buscarTodos();
	}

	@Produces
	@Named
	public List<VideosSeries> getListaCapitulosSeries() {
		return listaCapitulosSeries;
	}

	public void cuandoMiembroListaEsCambiado(
			@Observes(notifyObserver = Reception.IF_EXISTS) final VideosSeries miembro) {
		obtenerCapitulosSeries();

	}

}
