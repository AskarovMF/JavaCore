package com.javarush.task.task17.task1721;

import java.io.IOException;

public class CorruptedDataException extends IOException {
    public CorruptedDataException(String s) {
        System.out.println(s);
    }
}
