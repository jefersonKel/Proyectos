package com.tcs.netflix.service;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.tcs.netflix.dao.CapitulosSerieDao;
import com.tcs.netflix.entity.VideosSeries;

@RequestScoped
public class CapituloSerieService {
	@Inject
	private CapitulosSerieDao capitulosSerieDao;
	@Inject
	private Event<VideosSeries> capituSerieEvento;

	public void crearCaituloSerie(VideosSeries videoSerie) {
		capitulosSerieDao.guardar(videoSerie);
		capituSerieEvento.fire(videoSerie);
	}

}
