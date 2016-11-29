package com.tcs.netflix.producer;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProducer {
	@Produces
	@RequestScoped
	public FacesContext producirFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}
