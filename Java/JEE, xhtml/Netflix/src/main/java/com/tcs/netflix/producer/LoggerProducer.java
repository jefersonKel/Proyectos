package com.tcs.netflix.producer;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggerProducer {
	@Produces
	public Logger producidirLogger(InjectionPoint InjectionPoint) {
		return Logger.getLogger(InjectionPoint.getMember().getDeclaringClass().getName());
	}
}
