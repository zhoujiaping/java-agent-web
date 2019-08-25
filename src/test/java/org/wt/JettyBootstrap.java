package org.wt;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;

public class JettyBootstrap {
    public static void main(String[] args) throws Exception {
        // 创建Server
        Server server = new Server(8080);
        WebAppContext webContext = new WebAppContext("src/main/webapp", "/");
        //webContext.setDescriptor(projectRoot+"src/main/webapp/WEB-INF/web.xml");
        //webContext.setResourceBase(projectRoot+"src/main/webapp");
//webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
//server.setHandler(webContext);
        server.insertHandler(webContext);
        server.stop();
        server.start();
        server.join();
    }
}

