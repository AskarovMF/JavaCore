package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
       // fileName=(String) in.readObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try {
            Solution solution = new Solution("C:\\for_studying\\список1.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(solution.stream);
            outputStream.writeObject(solution);

            FileInputStream fiStream = new FileInputStream("C:\\for_studying\\список1.txt");
            ObjectInputStream ooi  = new ObjectInputStream(fiStream);
            Solution solution1 = (Solution)ooi.readObject();
            ObjectOutputStream outputStreamOut = new ObjectOutputStream(solution1.stream);
            outputStreamOut.writeObject(solution1);
            solution.close();
            solution1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }/*
        try {
            Solution solution = new Solution("C:\\for_studying\\список1.txt");
            String str = "Я не понимаю, как это работает";
            solution.writeObject(str);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\for_studying\\список2.txt"));
            solution.writeObject(out);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\for_studying\\список2.txt"));
            Solution loadedSolution = (Solution) in.readObject();
            loadedSolution.writeObject(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.getException();
        }

    }*/
}
