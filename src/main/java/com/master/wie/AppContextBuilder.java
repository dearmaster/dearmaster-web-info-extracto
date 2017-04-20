package com.master.wie;

import org.eclipse.jetty.webapp.WebAppContext;

public class AppContextBuilder {
	
	private WebAppContext webAppContext;
	
	public WebAppContext buildWebAppContext(String ctxPath) {
		webAppContext = new WebAppContext();
		webAppContext.setDescriptor(webAppContext + "/WEB-INF/web.xml");
		webAppContext.setResourceBase(".");
		webAppContext.setContextPath(ctxPath);
		return webAppContext;
	}
	
}