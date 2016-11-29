package com.tcs.netflix.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.tcs.netflix.entity.VideosPeliculas;
import com.tcs.netflix.entity.VideosTipos;
import com.tcs.netflix.service.GestorCompras;
import com.tcs.netflix.service.GestorImagen;
import com.tcs.netflix.service.PeliculaService;

@Model
public class PeliculaController {
	@Named
	@Produces
	private VideosPeliculas pelicula;
	@Inject
	private PeliculaService peliculaService;
	@Inject
	private MensajesController mensajesController;
	@Inject
	private GestorImagen gestorImagen;
	@Inject
	private GestorCompras gestorCompras;
	private Part fileUpload;
	private static final String RUTA_IMAGEN_PROYECTO = "../imagenes/Peliculas/";

	@PostConstruct
	private void inicializarPelicula() {
		pelicula = new VideosPeliculas();
	}

	public void crearPelicula() throws IOException {
		pelicula.setImagenVideo(RUTA_IMAGEN_PROYECTO + fileUpload.getSubmittedFileName());
		peliculaService.crearPelicula(pelicula);
		gestorImagen.crearImagen(this.fileUpload.getSubmittedFileName(), gestorImagen.RUTA_PELICULAS);
		inicializarPelicula();
		mensajesController.setInfoMessage("Se guardo Pelicula con exito");
	}

	public void eliminarPelicula(VideosPeliculas pelicula) {
		peliculaService.eliminarVideo(pelicula);
		mensajesController.setInfoMessage("Se elimino con exito");
	}

	public void agregarCompraVideo(int id) throws IOException {
		VideosPeliculas pelicula = peliculaService.buscarPeliculaId(id);
		gestorCompras.agregarPelicula(pelicula);
		mensajesController.setInfoMessage("Se Agrego Pelicula con exito");
	}
	
	public void eliminarCompraVideo(VideosPeliculas pelicula ) {
		gestorCompras.eliminarPelicula(pelicula);
		mensajesController.setInfoMessage("Se Elimino Pelicula de la lista");
	}

	public int valorTotalPelicula() {
		return gestorCompras.getTotalValorPelicula();
	}

	public List<VideosPeliculas> verPeliculasCompra() {
		return gestorCompras.getListaCompraPelicula();
	}

	public List<VideosPeliculas> buscarVideosTipo(String tipo) {
		return peliculaService.buscarPeliculaTipo(tipo);
	}

	public List<VideosTipos> getTipoVideo() {
		return Arrays.asList(VideosTipos.values());
	}

	public Part getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(Part fileUpload) {
		this.fileUpload = fileUpload;
	}
}
