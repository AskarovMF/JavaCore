package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread testThread = new TestThread();
        testThread.start();
        Thread.sleep(3500);
        testThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        private int second = 4;
        public void run(){
            try {
                while (!isInterrupted()){
                    System.out.print(second + " ");
                    Thread.sleep(1000);
                    if (second>0) second--;
                    else return;
                }
            } catch (Exception e) {
                System.out.print("прервано!");
            }
        }
    }
}