package com.tcs.netflix.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcs.netflix.entity.Usuarios;
import com.tcs.netflix.entity.UsuariosTipos;
import com.tcs.netflix.service.GestorCompras;
import com.tcs.netflix.service.SesionUsuario;
import com.tcs.netflix.service.UsuarioService;

@Model
public class UsuarioController {

	@Named
	@Produces
	private Usuarios usuario;
	@Inject
	private UsuarioService usuarioService;
	@Inject
	private MensajesController mensajesController;
	@Inject
	private PaginasController paginasController;
	@Inject
	private SesionUsuario usuarioSesion;
	@Inject
	private GestorCompras gestorCompras;

	@PostConstruct
	private void inicializarUsuario() {
		usuario = new Usuarios();
	}

	public Usuarios getDatosUsuario()
	{
		return usuarioSesion.getUsuarioSesion();
	}
	public String getNombreUsuario()
	{
		return usuarioSesion.getNombreUsuario();
	}
	
	public void crearUsuario() {
		usuarioService.crearUsuario(usuario);
		inicializarUsuario();
		mensajesController.setInfoMessage("Se guardo Usuario con exito");
	}

	public String loginUsuario(Usuarios usuario) {
		Usuarios datos =usuarioService.loginUsuario(usuario);
		if (datos != null) {
			usuarioSesion.llenarDatos(datos, datos.getNombres());
			gestorCompras.iniciarCompra();
			return paginasController.irIndex();
		} else {
			mensajesController.setErrorMessage("Usuario/Contraseña incorrecta");
			return null;
		}
	}
	
	public String cerrarSesion()
	{
		usuarioSesion.limpiarDatos();
		
		return paginasController.irLogin();
	}

	public List<UsuariosTipos> getTiposUsuarios() {
		return Arrays.asList(UsuariosTipos.values());
	}
}
