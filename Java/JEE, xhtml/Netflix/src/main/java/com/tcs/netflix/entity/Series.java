package com.tcs.netflix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "series")
public class Series implements Serializable {
	private static final long serialVersionUID = 2863328826547522555L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min = 1, max = 25, message = "Ingrese una descripcion(max 25 caracteres)")
	private String nombreSerie;
	private VideosTipos tipoVideo;
	@Column(length = 100000)
	private byte[] imagen;
	@NotNull
	private String rutaImagen;
	@OneToMany(mappedBy = "serie")
	private List<VideosSeries> videosSeries;
	private int precio;

	public List<VideosSeries> getVideosSeries() {
		return videosSeries;
	}

	public void setVideosSeries(List<VideosSeries> videosSeries) {
		this.videosSeries = videosSeries;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreSerie() {
		return nombreSerie;
	}

	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}

	public VideosTipos getTipoVideo() {
		return tipoVideo;
	}

	public void setTipoVideo(VideosTipos tipoVideo) {
		this.tipoVideo = tipoVideo;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
