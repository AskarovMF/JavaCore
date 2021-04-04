package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IOException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new FileNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new SocketException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new Exception();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NumberFormatException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //напишите тут ваш код

    }
}
