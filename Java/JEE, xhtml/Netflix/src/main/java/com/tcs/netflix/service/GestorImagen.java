package com.tcs.netflix.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.ejb.Stateless;
import javax.imageio.ImageIO;

@Stateless
public class GestorImagen {
	public static final String RUTA_IMAGEN_PROYECTO = "../imagenes/";
	public final String RUTA_SERIES= "series/";
	public final String RUTA_PELICULAS= "Peliculas/";
	private static final String RUTA_IMAGEN_EQUIPO = "C:/Herramientas/workspace/Netflix/WebContent/views/imagenes/";
	/*private static final String RUTA_IMAGEN_EQUIPO ="F:/Java/workspace/Netflix/WebContent/views/imagenes/";*/

	public void crearImagen(String imagen, String carpeta ) throws IOException {
		BufferedImage originalImage = ImageIO.read(new File("C:/Imagen/"+imagen));
		ImageIO.write(originalImage, "jpg", new File(RUTA_IMAGEN_EQUIPO +carpeta+imagen));
	}
}
