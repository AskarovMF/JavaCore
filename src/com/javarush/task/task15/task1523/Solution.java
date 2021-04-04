package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    String s;
    int A;

    public Solution() {
    }
    private Solution(String s) {
        this.s = s;
    }
    protected Solution(int A) {
        this.A = A;
    }
    Solution(String s, int A) {
        this.s = s;
        this.A = A;
    }

    public static void main(String[] args) {

    }

}

