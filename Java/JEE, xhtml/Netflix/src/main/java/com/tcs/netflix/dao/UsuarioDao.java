package com.tcs.netflix.dao;

import javax.ejb.Stateless;

import com.tcs.netflix.entity.Usuarios;

@Stateless
public class UsuarioDao extends AbstractDao<Usuarios> {

	private static final long serialVersionUID = 7750195315744163820L;

	public UsuarioDao() {
		super(Usuarios.class);
	}

}
