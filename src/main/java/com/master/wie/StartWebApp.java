package com.master.wie;

import com.master.wie.log.LoggerFactory;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class StartWebApp {
	
	private static final Logger logger = LoggerFactory.getLogger();
	private static final String ctxPath = "/dearmaster";
    private static final int DEFAULT_SERVER_PORT = 8080;
	
	public static void main(String[] args) {
        try {
            startServer();
            startExplorer();
        } catch (Exception e) {
            logger.error(e);
        }
	}

    private static void startServer() throws Exception {
        ContextHandlerCollection ctx = new ContextHandlerCollection();
        ctx.setHandlers(new Handler[] { new AppContextBuilder().buildWebAppContext(ctxPath) });
        final JettyServer jettyServer = new JettyServer(DEFAULT_SERVER_PORT);
        jettyServer.setHandler(ctx);
        try {
            if(jettyServer.isStarted()) {
                jettyServer.stop();
            } else if(jettyServer.isStopped()) {
                jettyServer.start();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static void startExplorer() {
        /*String str = "cmd /c start iexplore http://localhost:" + DEFAULT_SERVER_PORT + ctxPath;
        try {
            Runtime.getRuntime().exec(str);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        String appUrl = "http://localhost:" + DEFAULT_SERVER_PORT + ctxPath;
        try {
            URI uri = new URI(appUrl);
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}