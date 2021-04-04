package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        String A;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            while (!(A = reader.readLine()).equals("exit")){
                try {
                    if (A.contains(".")) {
                        Double B = Double.parseDouble(A);
                        print(B);
                    } else {
                    Integer C = Integer.parseInt(A);
                    if (C>0 && C<128) {
                        short S = Short.parseShort(A);
                        print(S);
                    }
                    else print(C);
                }
                }
                catch (Exception e){
                    print(A);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
