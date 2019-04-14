package com.demo.cssbug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.CssLinkResourceTransformer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@SpringBootApplication
public class SpringCssBugDemoApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringCssBugDemoApplication.class, args);
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("*/**")
			.addResourceLocations("classpath:META-INF/resources/")
			.resourceChain(false)
			.addResolver(new VersionResourceResolver()
					.addContentVersionStrategy("/css/**"))
			.addTransformer(new CssLinkResourceTransformer());
	}
	

}
