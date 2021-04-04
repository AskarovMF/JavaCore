package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));) {
            while (true){
                String text = reader.readLine();
                writer.write(text + "\n");
                writer.flush();
            if (text.equals("exit")) break;}
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            reader.close();
        }

    }
}
