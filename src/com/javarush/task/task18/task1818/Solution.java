package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fName1 = reader.readLine();
            String fName2 = reader.readLine();
            String fName3 = reader.readLine();
            reader.close();

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fName2), 200);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fName1, true), 200);
            int i;
            while ((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
            BufferedInputStream bufferedInputStream1 = new BufferedInputStream(new FileInputStream(fName3), 200);
            while ((i=bufferedInputStream1.read())!=-1){
                bufferedOutputStream.write(i);
            }
            bufferedInputStream.close();
            bufferedInputStream1.close();
            bufferedOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
