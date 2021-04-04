package com.javarush.task.task14.task1411;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        List<String> keys = new ArrayList<>();
        while (true){
            key = reader.readLine();
            if (key.equals("user")) keys.add(key);
            else if (key.equals("loser")) keys.add(key);
            else if (key.equals("coder")) keys.add(key);
            else if (key.equals("proger")) keys.add(key);
            else {
                reader.close();
                break;
            }
        }

        for (String x: keys) {
            if (x.equals("user")) person = new Person.User();
            else if (x.equals("loser")) person = new Person.Loser();
            else if (x.equals("coder")) person = new Person.Coder();
            else if (x.equals("proger")) person = new Person.Proger();

            //создаем объект, пункт 2

            doWork(person); //вызываем doWork
        }


    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) ((Person.User) person).live();
        else if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        else if (person instanceof Person.Coder) ((Person.Coder) person).writeCode();
        else if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
    }
}
