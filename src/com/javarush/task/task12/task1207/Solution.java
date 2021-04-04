package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        int a=5;
        Integer b = 5;
        print(a);
        print(b);
    }
    static void print (int a){
        a+=1;
    }
    static void print (Integer a){
        a-=1;
    }
    //Напишите тут ваши методы
}
