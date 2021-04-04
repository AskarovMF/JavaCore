package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {
        try {
            ImageReader reader = ImageReaderFactory.getImageReader(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
