package com.javarush.task.task20.task2014;

import jdk.nashorn.api.scripting.AbstractJSObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Externalizable {
    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\for_studying\\список1.txt"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\for_studying\\список1.txt"));

            Solution savedObject = new Solution(15);
            savedObject.writeExternal(out);

            Solution loadedObject = new Solution(20);
            loadedObject.readExternal(in);

            out.close();
            in.close();

            System.out.println(savedObject);
            System.out.println(loadedObject);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      //  System.out.println(new Solution(4));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(string);
        out.close();
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        string = (String) in.readObject();
        in.close();
    }
}
