package com.practice.designpatterns.creational.singleton;

public class Test {
    
    public static void main(String[] args) {
        
        Runnable task1 = () -> {
            SingletonPattern instance1 = SingletonPattern.getInstance();
            System.out.println("instance 1 : " + instance1.hashCode());
        };
        

        for(int i = 0; i < 200; i++) {
            Thread t1 = new Thread(task1);
            Thread t2 = new Thread(task1);
            Thread t3 = new Thread(task1);
            Thread t4 = new Thread(task1);
            Thread t5 = new Thread(task1);
            Thread t6 = new Thread(task1);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
                t5.join();
                t6.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

}
