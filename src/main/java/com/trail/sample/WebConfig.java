package com.trail.sample;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{

	@Autowired
	ApplicationConfig applicationConfig ;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("security/login");
	}

	@Bean
	public TemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("templates/");
		// resolver.setSuffix(".html");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String rootPath = System.getProperty("user.home"); 
		if (rootPath != null) {
			String imagePath = "file:" + rootPath + File.separator + "Profiles/";
			System.out.println(imagePath);
			File dir = new File(rootPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			registry.addResourceHandler("/Profiles"+"/**").addResourceLocations(imagePath);
		}
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);;
	}
	
}
