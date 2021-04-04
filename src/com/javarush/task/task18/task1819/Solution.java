package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            File fileName1 = new File(reader.readLine());
            File fileName2 = new File(reader.readLine());
            reader.close();
            FileInputStream fis1 = new FileInputStream(fileName1);
            FileInputStream fis2 = new FileInputStream(fileName2);
            byte[] bytes1 = new byte[fis1.available()];
            byte[] bytes2 = new byte[fis2.available()];

            fis1.read(bytes1);
            fis1.close();

            fis2.read(bytes2);
            fis2.close();

            byte [] bigBuf = new byte[(bytes1.length+bytes2.length)];
            int j = 0;
            for (int i = 0; i < bigBuf.length; i++) {
                if (i<bytes2.length){
                    bigBuf[i] = bytes2[i];
                }
                else {
                    bigBuf[i]=bytes1[j];
                    j++;
                }
            }
            FileOutputStream fos1 = new FileOutputStream(fileName1);

            fos1.write(bigBuf);
            fos1.close();
/*
            BufferedReader inputReader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader inputReader2 = new BufferedReader(new FileReader(fileName2));


            List<String> file1 = new ArrayList<>();
            List<String> file2 = new ArrayList<>();
            String line;
            while ((line = inputReader1.readLine())!=null){
                file1.add(line);
            }
            while ((line = inputReader2.readLine())!=null){
                file2.add(line);
            }
            file2.addAll(file1);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1));
            for (String x :
                    file2) {
                writer.write(x);
                System.out.println(x);
            }

*/
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
