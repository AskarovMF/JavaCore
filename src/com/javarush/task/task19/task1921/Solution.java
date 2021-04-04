package com.javarush.task.task19.task1921;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            while (reader.ready()){
                String[] strings = reader.readLine().split(" ");
                int count = strings.length;
                int day = Integer.parseInt(strings[count-3]);
                int month = Integer.parseInt(strings[count-2]);
                int year = Integer.parseInt(strings[count-1]);
                Calendar calendar = new GregorianCalendar(year,month-1,day);
                Date birthday = calendar.getTime();
                String name= "";
                for (int i = 0; i < count - 3; i++) {
                    name+=strings[i] + " ";
                }
                name = name.trim();
                PEOPLE.add(new Person(name, birthday));
            }
            for (Person x: PEOPLE) {
                System.out.println(x.getName() + " " + x.getBirthDate());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
