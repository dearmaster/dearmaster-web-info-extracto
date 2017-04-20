package com.master.wie;

import com.master.wie.log.LoggerFactory;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

public class JettyServer {
	
	private Server server;
	private static final Logger logger = LoggerFactory.getLogger();
	
	public JettyServer(int port) {
		server = new Server(port);
	}
	
	public void setHandler(ContextHandlerCollection contexts) {
		server.setHandler(contexts);
	}
	
	public void start() throws Exception {
		server.start();
		logger.info("Jetty server started");
	}
	
	public void stop() throws Exception {
		server.stop();
		server.join();
		logger.info("Jetty server stopped");
	}
	
	public boolean isStarted() {
		return server.isStarted();
	}
	
	public boolean isStopped() {
		return server.isStopped();
	}

}