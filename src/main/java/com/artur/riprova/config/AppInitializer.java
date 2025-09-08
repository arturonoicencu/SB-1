package com.artur.riprova.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Permette la creazione della classe di configurazione del dispatcher
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Dichiara la tua classe di configurazione web qui.
		// Questo dice al DispatcherServlet di caricare la configurazione da WebMvcConfig.
		return new Class[] {WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// L'intera app verrà gestita da questo DispatcherServlet.
		return new String[] {"/"};
	}

}
