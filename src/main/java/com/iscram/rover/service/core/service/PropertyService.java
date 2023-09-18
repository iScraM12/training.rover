package com.iscram.rover.service.core.service;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PropertyService {
	public String getHostname() throws UnknownHostException {
		return Inet4Address.getLocalHost()
				.getHostName();
	}
}
