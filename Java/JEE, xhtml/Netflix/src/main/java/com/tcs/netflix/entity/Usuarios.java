package com.tcs.netflix.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

	private static final long serialVersionUID = -5716059567291999981L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nombres;
	@NotNull
	private String correo;
	@NotNull
	private String password;
	private UsuariosTipos tipo;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuariosTipos getTipo() {
		return tipo;
	}

	public void setTipo(UsuariosTipos tipo) {
		this.tipo = tipo;
	}

}
