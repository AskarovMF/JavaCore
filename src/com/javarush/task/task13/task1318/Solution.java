package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String path = reader.readLine();
        InputStream instream = null;
        BufferedInputStream buffer = null;
        ArrayList<Character> data = new ArrayList<>();
        try{
            instream = new FileInputStream (path);
            buffer = new BufferedInputStream(instream);
            while (buffer.available()>0){
                char c = (char) buffer.read();
                data.add(c);
            }
                for (Character x : data) {
                    System.out.print(x);
                }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            reader.close();
            instream.close();
            buffer.close();
        }


    }
}