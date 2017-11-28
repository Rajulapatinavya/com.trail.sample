package com.trail.sample;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ApplicationConfig {

	
	@Value("${port:8086}")
	private String port;
	
	@Value("${context:/info}")
	private String context;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	private Set<ErrorPage> pageHandlers;

	@PostConstruct
	private void init() {
		pageHandlers = new HashSet<ErrorPage>();
		pageHandlers.add(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
		pageHandlers.add(new ErrorPage(HttpStatus.FORBIDDEN, "/forbidden.html"));
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		System.out.println("Context loaded");
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(Integer.valueOf(port));
		factory.setContextPath(context);
		factory.setErrorPages(pageHandlers);
		return factory;
	}
	
	
}
