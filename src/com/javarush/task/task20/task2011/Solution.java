package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable ??? ????????????
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) {
        Apartment apartment = new Apartment("Vorontsovsky", 1990);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\for_studying\\список1.txt"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\for_studying\\список1.txt"));
            apartment.writeExternal(out);
            Apartment newApartment = new Apartment();
            newApartment.readExternal(in);
            System.out.println(newApartment);
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
