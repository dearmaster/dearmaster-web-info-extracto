package com.master.wie;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

import com.master.wie.log.LoggerFactory;

public class StartWebApp {
	
	private static final Logger logger = LoggerFactory.getLogger();
	private static final String ctxPath = "/dearmaster";
	
	public static void main(String[] args) {
		ContextHandlerCollection ctx = new ContextHandlerCollection();
		ctx.setHandlers(new Handler[] { new AppContextBuilder().buildWebAppContext(ctxPath) });
		final JettyServer jettyServer = new JettyServer();
		jettyServer.setHandler(ctx);
		try {
			if(jettyServer.isStarted()) {
				jettyServer.stop();
			} else if(jettyServer.isStopped()) {
				jettyServer.start();
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

}