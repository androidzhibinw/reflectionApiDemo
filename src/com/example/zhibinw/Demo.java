package com.example.zhibinw;

public class Demo implements ProxyDemo.DemoInterface{

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add() {
        System.out.println("Demo.add");        
    }

}
