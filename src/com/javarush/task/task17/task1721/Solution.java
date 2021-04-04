package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String file1 = readerConsole();
        String file2 = readerConsole();
        allLines = readerFile(file1);
        forRemoveLines = readerFile(file2);
        Solution solution = new Solution();
        try {
            solution.joinData();
            reader.close();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println(e);
        }
        for (String x: allLines) {
            System.out.println(x);
        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException ("Строки не найдены!");
        }
    }

    public static String readerConsole(){
        try {
            String nameFile = null;
            nameFile = reader.readLine();
            return nameFile;
        } catch (IOException e) {
            System.out.println("Строка не прочитана!");
        } return null;
    }

    public static List<String> readerFile(String name){
        List<String> file = new ArrayList<>();
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
            String str;
            while ((str = buffer.readLine())!=null){
                file.add(str);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
