
package com.example.zhibinw;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {

    /**
     * @param args
     */
    
    
    public interface DemoInterface {
        public void add();

    }

    public interface DemoInterface2 {
        public void delete();

    }


    static InvocationHandler handler = new InvocationHandler() {

        @Override
        public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
            Class<?>[] interfaces = arg0.getClass().getInterfaces();
            for (Class<?> i : interfaces) {
                System.out.println("interface:" + i);
            }
            if (arg1.getName().equals("add")) {
                Class c = Class.forName("com.example.zhibinw.Demo");
                DemoInterface di = (DemoInterface) c.newInstance();
                di.add();

            }
            return null;
        }
    };

    public static void main(String[] args) {
        Object f = Proxy.newProxyInstance(DemoInterface.class.getClassLoader(),
                new Class[] {
                        DemoInterface.class,
                        DemoInterface2.class
                },
                handler);
        ((DemoInterface) f).add();
        ((DemoInterface2) f).delete();

    }
}
