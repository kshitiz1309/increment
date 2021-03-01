package com.cdac.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

	/**
	 * This is used for dispatcher servlet initialization and loading configuration class(MyAppConfiguration)
	 * @see MyAppConfiguration
	 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConf.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConf.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*" };
	}
}
