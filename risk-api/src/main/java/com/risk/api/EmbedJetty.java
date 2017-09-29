package com.risk.api;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.InputStream;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.Properties;

public class EmbedJetty {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        InputStream in = EmbedJetty.class.getResourceAsStream("/WEB-INF/classes/config.properties");
        prop.load(in);
        String port = prop.getProperty("rest.port").trim();
        String contextPath = prop.getProperty("rest.contextpath").trim();
        System.err.println(port);
        System.err.println(contextPath);
        Server server = new Server(Integer.valueOf(port));
        ProtectionDomain domain = EmbedJetty.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath(contextPath);

        webapp.setWar(location.toExternalForm());
        server.setHandler(webapp);
        server.start();
        server.join();
    }
}