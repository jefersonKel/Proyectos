package com.tcs.netflix.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Videos implements Serializable {

	private static final long serialVersionUID = -8125625050752289122L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min = 1, max = 100, message = "Ingrese una descripcion(max 100 caracteres)")
	private String tituloVideo;
	private String duracionVideo;
	private String sipnosisVideo;
	private String imagenVideo;
	private int precio;

	public int getId() {
		return id;
	}

	public void setId(int idVideo) {
		this.id = idVideo;
	}

	public String getTituloVideo() {
		return tituloVideo;
	}

	public void setTituloVideo(String tituloVideo) {
		this.tituloVideo = tituloVideo;
	}

	public String getDuracionVideo() {
		return duracionVideo;
	}

	public void setDuracionVideo(String duracionVideo) {
		this.duracionVideo = duracionVideo;
	}

	public String getDescripcionVideo() {
		return sipnosisVideo;
	}

	public void setDescripcionVideo(String descripcionVideo) {
		this.sipnosisVideo = descripcionVideo;
	}

	public String getImagenVideo() {
		return imagenVideo;
	}

	public void setImagenVideo(String imagenVideo) {
		this.imagenVideo = imagenVideo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
