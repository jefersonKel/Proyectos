package com.tcs.netflix.controller;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Stateless
public class MensajesController {

	@Inject
	private FacesContext facesContext;

	public void setInfoMessage(String message) {
		final FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
		this.facesContext.addMessage(null, mensaje);
	}

	public void setErrorMessage(String message) {
		final FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		this.facesContext.addMessage(null, mensaje);
	}
}
