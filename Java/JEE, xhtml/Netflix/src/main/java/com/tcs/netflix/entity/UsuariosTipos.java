package com.tcs.netflix.entity;

public enum UsuariosTipos {
ADMIN("Administrador","Admin"),  USER("Usuario","User");
	
	private String label;
	private String labelDB;
	
	private UsuariosTipos(String label, String labelDB) {
		this.label = label;
		this.labelDB = labelDB;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLabelDB() {
		return labelDB;
	}
	public void setLabelDB(String labelDB) {
		this.labelDB = labelDB;
	}
	
}
