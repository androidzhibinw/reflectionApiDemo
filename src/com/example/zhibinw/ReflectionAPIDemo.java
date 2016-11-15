
package com.example.zhibinw;

import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public class ReflectionAPIDemo {
    String mMemberString = new String("hello");
    int mMemberInt = 10;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReflectionAPIDemo demo = new ReflectionAPIDemo();
        demo.testClass();
        demo.testClassInterface();
        demo.testCreateInstance();
        demo.testInvokeMethod();

    }

    private void testClass() {
        System.out.println("testClass: ==>");
        System.out.println("mMember.getClass():" + mMemberString.getClass());
        // System.out.println("mMember.getClass():" + mMemberInt.getClass());
        System.out.println("int.class:" + int.class);
        System.out.println("Integer.TYPE:" + Integer.TYPE);
        try {
            System.out.println("Class.forName():"
                    + Class.forName("com.example.zhibinw.ReflectionAPIDemo"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Class.forName():"
                    + Class.forName("java.lang.String", true,
                            ReflectionAPIDemo.class.getClassLoader()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void testClassInterface() {
        System.out.println("testClassInterface: ==>");
        System.out.println("modifiers:"
                + Modifier.toString(mMemberString.getClass().getModifiers()));
        TypeVariable[] tVariables = ArrayList.class.getTypeParameters();
        for (TypeVariable tv : tVariables) {
            System.out.println("type variables:" + tv);
        }
        java.lang.reflect.Type[] intfsTypes = mMemberString.getClass().getGenericInterfaces();
        for (java.lang.reflect.Type tp : intfsTypes) {
            System.out.println("tp:" + tp);
        }

        Annotation[] aos = null;
        aos = mMemberString.getClass().getAnnotations();
        for (Annotation ao : aos) {
            System.out.println("ao:" + ao);

        }
        System.out.println("getCanonicalName:" + mMemberString.getClass().getCanonicalName());
        System.out.println("getName:" + mMemberString.getClass().getName());
        Field[] fields = mMemberString.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            System.out.println("field:" + f);
            // try {
            // System.out.println("field:" + f.get(mMemberString));
            // } catch (IllegalArgumentException e) {
            // e.printStackTrace();
            // }

        }
        Constructor[] constructors = mMemberString.getClass().getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("cons:" + c);
        }

        Method[] methods = mMemberString.getClass().getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("m:" + m);
            // Class [] csClasses =m.getParameterTypes();
            // for (Class c:csClasses){
            // System.out.println("cs:" + c);
            // }
        }
    }

    private void testCreateInstance() {
        System.out.println("testCreateInstance: ==>");

        Object myString = null;
        Constructor constructor = null;
        try {
            constructor = mMemberString.getClass().getDeclaredConstructor(String.class);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            myString = constructor.newInstance("Hello");
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("myString:" + myString);
    }

    private void testInvokeMethod() {
        System.out.println("testInvokeMethod: ==>");
        Class classStr = null;
        Object object = null;
        Method method = null;
        try {
            classStr = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
             object = classStr.newInstance();
        } catch (InstantiationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
             method = classStr.getMethod("toString");
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            System.out.println("invoke:"+ method.invoke(object));
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
