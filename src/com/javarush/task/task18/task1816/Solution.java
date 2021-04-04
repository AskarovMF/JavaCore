package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        File fileName = new File(args[0]);
        int count = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            int i;
            while ((i=fileInputStream.read())!=-1){
                if (i>=65 && i<=90) count++;
                else if (i>= 97 && i<=122) count++;
            }
            fileInputStream.close();
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
          catch (IOException e){
            e.printStackTrace();
        }
    }
}
