package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long s;
        int m;
        List<Long> list = new ArrayList<>();
        for (long i = 0; i <N ; i++) {
            s = i;
            String str = String.valueOf(s);
            m = str.length();
            String[] strs = str.split("");
            long summ = 0;
            for (String x : strs) {
                summ+=Math.pow(Integer.parseInt(x), m) ;
            }
            if (s==summ) list.add(s);
        }
        long[] result = new long[list.size()];
        for (int i = 0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
     //  List<Long> list = new ArrayList<>();
       long[] test =  getNumbers(100000);
        for (long x :
                test) {
            System.out.println(x);
        }
    }
}
