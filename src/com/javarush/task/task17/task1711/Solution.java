package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    List<String> mirror = new ArrayList<>();
                    Collections.addAll(mirror, args);
                    while (mirror.size() > 1) {
                        addPeople(mirror);
                        for (int i = 1; i <= 3; i++) {
                            mirror.remove(1);
                        }
                    }
                    break;
                }
            }
            case "-u": {
                synchronized (allPeople) {
                    List<String> mirror = new ArrayList<>();
                    Collections.addAll(mirror, args);
                    while (mirror.size() > 1) {
                        int id = Integer.parseInt(mirror.get(1));
                        Person person = allPeople.get(id);
                        person.setName(mirror.get(2));
                        if (mirror.get(3).equals("м")) person.setSex(Sex.MALE);
                        else person.setSex(Sex.FEMALE);
                        Date bd = dateFormat.parse(mirror.get(4));
                        person.setBirthDate(bd);
                        for (int i = 1; i <= 4; i++) {
                            mirror.remove(1);
                        }
                    }
                    break;
                }
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i<args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).removePerson();
                    }
                    break;
                }
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        Person person = allPeople.get(id);
                        person.getPerson();
                    }
                    break;
                }
            }
        }
    }

    public static void addPeople (List<String> mirror) throws ParseException {
        String name = mirror.get(1);
        Date bd = dateFormat.parse(mirror.get(3));
        if (mirror.get(2).equals("м")) {
            allPeople.add(Person.createMale(name, bd));
        } else allPeople.add(Person.createFemale(name, bd));
        System.out.println(allPeople.size() - 1);
    }
}
