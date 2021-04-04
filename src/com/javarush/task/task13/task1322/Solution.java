package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

import java.text.SimpleDateFormat;

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    static class StringObject implements SimpleObject{

    @Override
    public SimpleObject <String> getInstance() {
        return null;
    }
}
}
