package com.tcs.netflix.producer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcs.netflix.dao.UsuarioDao;
import com.tcs.netflix.entity.Usuarios;

@RequestScoped
public class UsuarioProducer {
	@Inject
	private UsuarioDao usuarioDao;
	@Inject
	private List<Usuarios> listaUsuarios;


	@PostConstruct
	private void obtenerUsuarios() {
		this.listaUsuarios = usuarioDao.buscarTodos();
		
	}
	

	@Produces
	@Named
	public List<Usuarios> getListaUsuarios() {
		return listaUsuarios;
		
	}	
	
	
	public void cuandoMiembroListaEsCambiado(@Observes(notifyObserver = Reception.IF_EXISTS) final Usuarios miembro) {
		obtenerUsuarios();

	}
	

}
