package com.tcs.netflix.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.tcs.netflix.dao.UsuarioDao;
import com.tcs.netflix.entity.Usuarios;

@Stateless
public class UsuarioService {

	@EJB
	private UsuarioDao usuarioDao;
	@Inject
	private Event<Usuarios> usuarioEvent;
	@Inject
	private Logger log;
	@Inject
	private List<Usuarios> listaUsuarios;

	public void crearUsuario(Usuarios usuario) {
		log.info("Se Guarda Usuario: " + usuario.getNombres());
		usuarioDao.guardar(usuario);
		usuarioEvent.fire(usuario);
	}

	public Usuarios loginUsuario(Usuarios usuario) {
		for (Usuarios usuarios : listaUsuarios) {
			if (usuarios.getCorreo().equals(usuario.getCorreo()) && (usuarios.getPassword().equals(usuario.getPassword()))) {
			return usuarios;
			}
		}
		return null;
	}

	public List<Usuarios> listarUsuarios() {
		return this.listaUsuarios = usuarioDao.buscarTodos();
	}
}
