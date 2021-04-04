package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        threads.get(2).start();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true){}
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()){}
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class Thread5 extends Thread {
        @Override
        public void run() {
            int result = 0;
            String str;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (!(str = reader.readLine()).equals("N")){
                    int a = Integer.parseInt(str);
                    result+=a;
                }
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}