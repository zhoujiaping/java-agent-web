package org.wt;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JettyGroovyBootstrap {
    public static String classpath = "/home/wt/IdeaProjects/java-agent-web/target/classes";
    public static void boot() throws Exception {
        File file = ResourceUtils.getFile("classpath:groovy/JettyBoot.groovy");
        GroovyShell shell = new GroovyShell();
        shell.evaluate(file);
    }

    public static void main(String[] args) throws Exception {
        GroovyClassLoader gcl = new GroovyClassLoader();
        ClassLoader cxtCl = Thread.currentThread().getContextClassLoader();
        gcl.addClasspath("/home/wt/IdeaProjects/java-agent-web/target/classes");
        ClassLoader cl = new MyClassLoader();
        Thread.currentThread().setContextClassLoader(cl);
        Class clazz = Class.forName(JettyGroovyBootstrap.class.getName(),true,cl);
        Method method = clazz.getMethod("boot");
        method.invoke(null);
    }
    public static class MyClassLoader extends ClassLoader{
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if(name.matches(".*[cC]lass[lL]oad.*")){
                System.out.println("find =>"+name);
            }
            Path path = Paths.get(classpath,name.replaceAll(".","/")+".class");
            if(path.toFile().exists()){
                if(name.startsWith("org/wt")){
                    System.out.println(this.getClass().getName()+" findClass("+name+")");
                }
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                try {
                    Files.copy(path,bos);
                    byte[] buf = bos.toByteArray();
                    return defineClass(buf,0,buf.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return super.findClass(name);
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if(name.matches(".*[cC]lass[lL]oad.*")){
                System.out.println("load =>"+name);
            }
            Path path = Paths.get(classpath,name.replaceAll(".","/")+".class");
            if(path.toFile().exists()){
                if(name.startsWith("org/wt")){
                    System.out.println(this.getClass().getName()+" loadClass("+name+")");
                }
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                try {
                    Files.copy(path,bos);
                    byte[] buf = bos.toByteArray();
                    return defineClass(buf,0,buf.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return super.loadClass(name);
        }
    }
}
