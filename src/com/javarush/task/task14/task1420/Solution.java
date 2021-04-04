package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    int a = 0, b = 0, c = 0;
    int nod = 0;

    public static void main(String[] args) throws Exception {
        int a = 0, b = 0, c = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
            if ((a<=0) || (b<=0)) throw new Exception();


        opredelitel(a,b,c);
        a = gcd(a,b);
        System.out.println(a);


    }
    public static void opredelitel (int a, int b, int c){
        if (a < b) {
            c = a;
            a = b;
            b = c;
        }
    }

        public static int gcd(int a,int b) {
            while (b !=0) {
                int tmp = a%b;
                a = b;
                b = tmp;
            }
            return a;
        }
    }

