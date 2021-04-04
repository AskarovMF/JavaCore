package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDate;

    private Person(String name, Sex sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public static Person createMale(String name, Date birthDate) {
        return new Person(name, Sex.MALE, birthDate);
    }

    public static Person createFemale(String name, Date birthDate) {
        return new Person(name, Sex.FEMALE, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public void getPerson(){
        String name = getName();
        Sex sex = getSex();
        String subSex = null;
        if (sex.toString().equals("MALE")) subSex = "м";
        else if (sex.toString().equals("FEMALE")) subSex = "ж";
        Date bd = getBirthDate();
        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        System.out.println(name + " " + subSex + " " + myDateFormat.format(bd));
    }

    public void removePerson(){
        setName(null);
        setSex(null);
        setBirthDate(null);
    }
}
