package org.wt;

import com.alibaba.dubbo.common.bytecode.ClassGenerator;
import com.alibaba.dubbo.common.bytecode.Wrapper;
import javassist.ClassPool;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.aop.support.AopUtils;

import java.io.File;
//-javaagent:/home/wt/IdeaProjects/java-agent/target/java-agent-jar-with-dependencies.jar=/home/wt/IdeaProjects/java-agent/src/main/resources/script
public class JettyBootstrap {
    public static void main(String[] args) throws Exception {
        // 创建Server
        ClassGenerator cg;
        Wrapper w;
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

