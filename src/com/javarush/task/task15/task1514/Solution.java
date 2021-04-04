package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(0.0, "Марат станет программистом");
        labels.put(1.0, "Обязательно станет программистом");
        labels.put(2.0, "Не здавайся");
        labels.put(3.0,"Все обязательно получится");
        labels.put(4.0, "Вот увидишь");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
