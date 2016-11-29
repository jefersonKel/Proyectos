package com.tcs.netflix.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "videosPeliculas")
public class VideosPeliculas extends Videos {

	private static final long serialVersionUID = 6456646201131306167L;
	@NotNull
	private String actoresPrincipales;
	private int premiosOscar;
	private boolean disponible;
	private VideosTipos clasificacionVideo;

	public String getActoresPrincipales() {
		return actoresPrincipales;
	}

	public void setActoresPrincipales(String actoresPrincipales) {
		this.actoresPrincipales = actoresPrincipales;
	}

	public int getPremiosOscar() {
		return premiosOscar;
	}

	public void setPremiosOscar(int premiosOscar) {
		this.premiosOscar = premiosOscar;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public VideosTipos getClasificacionVideo() {
		return clasificacionVideo;
	}

	public void setClasificacionVideo(VideosTipos clasificacionVideo) {
		this.clasificacionVideo = clasificacionVideo;
	}

}
