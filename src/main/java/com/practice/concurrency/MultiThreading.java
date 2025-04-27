package com.practice.concurrency;

public class MultiThreading {

//    private static final Object lock = new Object();
//    private static int number = 1;
//    private static char letter = 'A';
//
//    public static void main(String[] args) {
//        // Thread to print numbers
//        Thread numberThread = new Thread(() -> {
//            while (number <= 26) {
//                synchronized (lock) {
//                    System.out.print(number + " ");
//                    number++;
//                    lock.notify(); // Notify the character thread to print the next character
//                    try {
//                        if (number <= 26) {
//                            lock.wait(); // Wait for the character thread to print
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        // Thread to print characters
//        Thread characterThread = new Thread(() -> {
//            while (letter <= 'Z') {
//                synchronized (lock) {
//                    System.out.print(letter + " ");
//                    letter++;
//                    lock.notify(); // Notify the number thread to print the next number
//                    try {
//                        if (letter <= 'Z') {
//                            lock.wait(); // Wait for the number thread to print
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        // Start both threads
//        numberThread.start();
//        characterThread.start();
//    }

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 26; i++) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c = 'A'; c <= 'Z'; c++) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " " + c);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

}
