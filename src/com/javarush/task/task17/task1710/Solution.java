package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        switch (args[0]){
            case "-c": {
                String name = args[1];
                Date bd =dateFormat.parse(args[3]);
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(name, bd));
                } else allPeople.add(Person.createFemale(name, bd));
                //allPeople.get(allPeople.size()-1).getPerson();
                System.out.println(allPeople.size()-1);
                break;
            }
            case "-u": {
                int id = Integer.parseInt(args[1]);
                Person person = allPeople.get(id);
                person.setName(args[2]);
                if (args[3].equals("м")) person.setSex(Sex.MALE);
                else person.setSex(Sex.FEMALE);
                Date bd = dateFormat.parse(args[4]);
                person.setBirthDate(bd);
                break;
            }
            case "-d": {
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).removePerson();
                break;
            }
            case "-i": {
                int id = Integer.parseInt(args[1]);
                Person person = allPeople.get(id);
                person.getPerson();
            }
        }
     /*   for (Person x: allPeople){
           x.getPerson();
        }*/
    }
}
