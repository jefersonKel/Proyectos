package com.tcs.netflix.controller;

import javax.ejb.Stateful;
import javax.enterprise.inject.Model;

@Stateful
@Model
public class PaginasController {

	private static final String LOGIN = "/login";
	private static final String INDEX = "/index";

	public String irIndex() {
		return INDEX;
	}
	
	public String irLogin()
	{
		return LOGIN;
	}
}
