package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.logging.XMLFormatter;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        Set<String> list = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            while (!(str = reader.readLine()).equals("end")){
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] col = ((TreeSet<String>) list).first().split("\\.");
        String fileName = "";
        for (int i = 0; i<col.length; i++) {
            if (col[i].contains("part")) break;
            else fileName += col[i];
            fileName+=".";
        }
        String newFileName =  fileName.substring(0,fileName.length()-1);
        try {
            FileOutputStream writer = new FileOutputStream(newFileName, true);
            for (String x :
                    list) {
                FileInputStream input = new FileInputStream(x);
                byte [] buf = new byte[input.available()];
                input.read(buf);
                writer.write(buf);
                input.close();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
