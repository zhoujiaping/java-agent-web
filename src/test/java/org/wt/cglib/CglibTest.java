package org.wt.cglib;

import net.sf.cglib.core.ClassEmitter;
import net.sf.cglib.transform.*;
import org.junit.Test;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * http://devdoc.net/javamisc/cglib-3.2.5/
 */
public class CglibTest {
    @Test
    public void test0() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassLoader ccl = Thread.currentThread().getContextClassLoader();

        ClassVisitor v = new org.objectweb.asm.ClassWriter(0);

        ClassEmitter e = new ClassEmitter(v);
        //public MethodVisitor visitMethod(int access,String name,String desc,String signature,String[] exceptions);
        int access = 0;
        String name = "";
        String desc = "";
        String sig = "";
        String[] exceptions = new String[]{};//new String[]{"java.lang.Throwable"};
        e.visitMethod(access,name,desc,sig,exceptions);
       /* ClassFilter filter = new ClassFilter() {
            @Override
            public boolean accept(String classname) {
                return true;
            }
        };
        ClassTransformerFactory fac  = new ClassTransformerFactory() {
            @Override
            public ClassTransformer newInstance() {
                MethodFilterTransformer t = new MethodFilterTransformer();
                return null;
            }
        };
        TransformingClassLoader cl = new TransformingClassLoader(ccl,filter,fac);

        Class userclass = ccl.loadClass("org.wt.model.User");
        Method method = userclass.getMethod("getName");
        Object name = method.invoke(userclass.newInstance());
        System.out.println(name);*/
    }
}
