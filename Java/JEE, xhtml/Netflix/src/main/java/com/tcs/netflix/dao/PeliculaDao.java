package com.tcs.netflix.dao;

import javax.ejb.Stateful;

import com.tcs.netflix.entity.VideosPeliculas;

@Stateful
public class PeliculaDao extends AbstractDao<VideosPeliculas> {

	private static final long serialVersionUID = 1667116565082415110L;

	public PeliculaDao() {
		super(VideosPeliculas.class);
	}

}
