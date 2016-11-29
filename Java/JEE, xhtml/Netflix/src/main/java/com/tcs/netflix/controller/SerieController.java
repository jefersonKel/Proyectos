package com.tcs.netflix.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.tcs.netflix.entity.Series;
import com.tcs.netflix.entity.VideosTipos;
import com.tcs.netflix.service.GestorCompras;
import com.tcs.netflix.service.GestorImagen;
import com.tcs.netflix.service.SerieService;

@Model
public class SerieController {

	@Named
	@Produces
	private Series serie;
	@Inject
	private SerieService serieService;
	@Inject
	private MensajesController mensajesController;
	@Inject
	private GestorImagen gestorImagen;
	@Inject
	private GestorCompras gestorCompras;
	private static final String RUTA_IMAGEN_PROYECTO = "../imagenes/Series/";
	private Part fileUpload;

	@PostConstruct
	private void inicializarSerie() {
		serie = new Series();
	}

	public void crearSerie() throws IOException {

		serie.setImagen(convertirImagenByte());
		serie.setRutaImagen(RUTA_IMAGEN_PROYECTO + fileUpload.getSubmittedFileName());
		serieService.crerSerie(serie);
		gestorImagen.crearImagen(fileUpload.getSubmittedFileName(), gestorImagen.RUTA_SERIES);
		inicializarSerie();
		mensajesController.setInfoMessage("Se guardo Serie con exito");
	}

	public void eliminarSerie(Series serie) {
		serieService.eliminarSerie(serie);
		mensajesController.setInfoMessage("Se elimino con exito");
	}

	public void agregarCompraSerie(int id) throws IOException {
		Series serie = serieService.buscarSerieId(id);
		gestorCompras.agregarSerie(serie);
		mensajesController.setInfoMessage("Se Agrego Serie con exito");
	}
	
	public void eliminarCompraSerie(Series serie)  {
		gestorCompras.eliminarSerie(serie);
		mensajesController.setInfoMessage("Se Elimino Serie de la lista");
	}

	public List<Series> verSeriesCompra() {
		return gestorCompras.getListaCompraSerie();
	}

	public int valorTotalSerie() {
		return gestorCompras.getTotalValorSerie();
	}

	public List<Series> buscarSerieTipo(String tipo) {
		return serieService.buscarSerieTipo(tipo);
	}

	private String getRutaImagen() {
		String ruta = "C:/Imagen/" + fileUpload.getSubmittedFileName();
		return ruta;
	}

	private byte[] convertirImagenByte() throws IOException {

		File file = new File(getRutaImagen());
		InputStream inputStream = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputStream.read(buffer);
		inputStream.close();
		return buffer;
	}

	@SuppressWarnings("unused")
	private Image convertirByteImagen(byte[] imageInByte) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(imageInByte);
		BufferedImage imageFromConvert = ImageIO.read(inputStream);
		return imageFromConvert;
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
