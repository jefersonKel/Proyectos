package com.tcs.netflix.dao;

import javax.ejb.Stateless;

import com.tcs.netflix.entity.Series;

@Stateless
public class SerieDao extends AbstractDao<Series> {

	private static final long serialVersionUID = -5538606067705392392L;

	public SerieDao() {
		super(Series.class);
	}

}
