package org.wt;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.lang.reflect.Method;

public class JettyGroovyBootstrap {
    public static void boot() throws Exception {
        File file = ResourceUtils.getFile("classpath:groovy/JettyBoot.groovy");
        GroovyShell shell = new GroovyShell();
        shell.evaluate(file);
    }

    public static void main(String[] args) throws Exception {
        GroovyClassLoader gcl = new GroovyClassLoader();
        Class clazz = Class.forName(JettyGroovyBootstrap.class.getName(),true,gcl);
        Method method = clazz.getMethod("boot");
        method.invoke(null);
    }
}
