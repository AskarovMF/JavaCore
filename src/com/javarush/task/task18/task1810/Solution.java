package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream inputStream = new FileInputStream(reader.readLine());
                if (inputStream.available()<1000) {
                    reader.close();
                    inputStream.close();
                    throw new DownloadException();
                }
            }
        }
        catch (IOException e){
        }

    }

    public static class DownloadException extends Exception {

    }
}
