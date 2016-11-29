package com.tcs.netflix.entity;

public enum VideosTemporadas {
	TEMPORADA1("Temporada 1", "temporada 1"), TEMPORADA2("Temporada 2", "temporada 2"), TEMPORADA3("Temporada 3",
			"temporada 3");
	private String label;
	private String labelDB;

	private VideosTemporadas(String label, String labelDB) {
		this.setLabel(label);
		this.setLabelDB(labelDB);
	}

	public String getLabelDB() {
		return labelDB;
	}

	public void setLabelDB(String labelDB) {
		this.labelDB = labelDB;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
