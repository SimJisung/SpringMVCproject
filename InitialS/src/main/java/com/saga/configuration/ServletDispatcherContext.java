package com.saga.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.SimpleSpringPreparerFactory;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * @author simjisung
 * @see ServletDispachterContext 기본적으로 viewResolver 설정 하는 부분이다. 
 * 
 */
@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan(basePackages="com.saga.app.controller.*")
public class ServletDispatcherContext extends WebMvcConfigurerAdapter{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
		
	@Bean
	public UrlBasedViewResolver tilesViewResolver(){
		UrlBasedViewResolver tilesResolver = new UrlBasedViewResolver();
		tilesResolver.setViewClass(TilesView.class);
		return tilesResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tc = new TilesConfigurer();
		tc.setDefinitions("/WEB-INF/views/tiles/tiles.xml");
		return tc;
	}
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
