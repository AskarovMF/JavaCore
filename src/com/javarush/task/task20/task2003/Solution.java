package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();


    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream inputStream = new FileInputStream(rd.readLine());
            rd.close();
            load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream,"New stream");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        properties.putAll((Map)prop);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        OutputStream outputStream2 = new FileOutputStream("C:\\for_studying\\список2.txt");
        try {
            solution.save(outputStream2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            outputStream2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
