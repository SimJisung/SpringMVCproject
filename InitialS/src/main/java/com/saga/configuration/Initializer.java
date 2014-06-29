package com.saga.configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * @author simjisung
 * @see Initializer 클래스는 web.xml을 대신하는 클래스 이다. 
 * 
 */
public class Initializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		setRootContext(servletContext);
	
		setDispatcherContext(servletContext);
		
		setCharacterUTF8Encoding(servletContext);
		
		
	}

	private void setRootContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContext.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
	}

	private void setDispatcherContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(ServletDispatcherContext.class);
		
		Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}
	
	private void setCharacterUTF8Encoding(ServletContext servletContext) {
		FilterRegistration.Dynamic filter = servletContext.addFilter("CHARACTER_ENCODING_FILTER", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", "UTF-8");
        filter.setInitParameter("forceEncoding", "true");
        filter.addMappingForUrlPatterns(null, false, "/*");
	}

}
