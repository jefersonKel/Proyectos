package com.tcs.netflix.service;

import java.io.Serializable;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.tcs.netflix.entity.Usuarios;

@Singleton
@Startup
public class SesionUsuario implements Serializable {

	private static final long serialVersionUID = 3211756557580285350L;
	private Usuarios usuarioSesion;
	private String NombreUsuario;
	private String tipoUSuario;

	public void llenarDatos(Usuarios usuario, String nombre) {
		this.usuarioSesion= new Usuarios();
		this.usuarioSesion=usuario;
		this.NombreUsuario=nombre;
	}
	
	public void limpiarDatos()
	{
		this.usuarioSesion= new Usuarios();
		this.NombreUsuario=null;
	}
	
	public Usuarios getUsuarioSesion() {
		return usuarioSesion;
	}

	public void setUsuarioSesion(Usuarios usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getTipoUSuario() {
		return tipoUSuario;
	}

	public void setTipoUSuario(String tipoUSuario) {
		this.tipoUSuario = tipoUSuario;
	}

}
