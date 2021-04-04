package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter (Scanner scanner){
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String str =  fileScanner.nextLine();
            String [] subString = str.split(" ");
            String firstName = subString[1];
            String middleName = subString[2];
            String lastName = subString[0];
            int day = Integer.parseInt(subString[3]);
            int month = Integer.parseInt(subString [4]) ;
            int year = Integer.parseInt(subString [5]);
            Calendar calendar = new GregorianCalendar(year,month-1,day);
            Date birthDate = calendar.getTime();
            return new Person(firstName,middleName, lastName,birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
