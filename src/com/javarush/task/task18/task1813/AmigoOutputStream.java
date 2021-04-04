package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream outputStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.outputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        outputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        outputStream.flush();
        String str = "JavaRush © All rights reserved.";
        byte [] bite = str.getBytes();
        outputStream.write(bite);
        outputStream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
