package com.tcs.netflix.entity;

public enum VideosTipos {
	TERROR("Terror", "terror"), ACCION("Accion", "accion"), ROMANCE("Romance", "romance"), DRAMA("Drama", "drama");

	private String label;
	private String labelDB;

	private VideosTipos(String label, String labelDB) {
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
