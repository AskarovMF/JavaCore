package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {

        super(fileName);
        if (!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();// UnsupportedFileNameException.

        }
    }

    public static void main(String[] args) {
        try {
            TxtInputStream txtInputStream = new TxtInputStream("C:\\for studying\\test.BMP");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedFileNameException e) {
            e.printStackTrace();
        }
    }
}

