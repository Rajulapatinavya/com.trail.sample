package com.trail.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.trail.sample"})
@EntityScan("com.trail.sample")
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    
}
