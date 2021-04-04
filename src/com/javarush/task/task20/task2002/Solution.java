package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("C:\\for_studying\\список1.txt", null);
            OutputStream outputStream = new FileOutputStream("C:\\for_studying\\список1.txt");
            InputStream inputStream = new FileInputStream("C:\\for_studying\\список1.txt");
          //  OutputStream outputStream2 = new FileOutputStream("C:\\for_studying\\список2.txt");


            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User Pavel = new User();
            Pavel.setFirstName("Pavel");
            Pavel.setLastName("Ustinov");
            Pavel.setBirthDate(new Date());
            Pavel.setMale(true);
            Pavel.setCountry(User.Country.UKRAINE);

            User Maria = new User();
            Maria.setFirstName("Maria");
            Maria.setLastName("Kulikova");
            Maria.setBirthDate(new Date());
            Maria.setMale(false);
            Maria.setCountry(User.Country.RUSSIA);

            User Marat = new User();
            Marat.setFirstName("Marat");
            Marat.setLastName("Askarov");
            Marat.setBirthDate(new Date());
            Marat.setMale(true);
            Marat.setCountry(User.Country.OTHER);

            javaRush.users.add(Pavel);
            javaRush.users.add(Maria);
            javaRush.users.add(Marat);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(Pavel));
         //   loadedObject.save(outputStream2);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String isUsers = this.users.size()>0? "yes": "no";
            writer.println(isUsers);

            if (isUsers.equals("yes")) {
                for (User user :
                        users) {
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());

                 //   SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy HH:mm:ssS");
                    writer.println(/*dateFormat.format(*/user.getBirthDate().getTime());

                    writer.println(user.isMale());
                    writer.println(user.getCountry().getDisplayName());
                }
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUserPresent = reader.readLine();
            if (isUserPresent.equals("yes")) {
                int i = 0;
            while (reader.ready()){
                this.users.add(new User());
                    users.get(i).setFirstName(reader.readLine());
                    users.get(i).setLastName(reader.readLine());

                  //  SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy HH:mm:ssS");
                    String date = reader.readLine();
                    Date birthDay = new Date(Long.parseLong(date));
                    users.get(i).setBirthDate(birthDay);

                    boolean isMale = reader.readLine().equals("true");
                    users.get(i).setMale(isMale);

                    String country = reader.readLine();
                    if (country.equals("Ukraine")) {
                        users.get(i).setCountry(User.Country.UKRAINE);
                    } else if (country.equals("Russia")) {
                        users.get(i).setCountry(User.Country.RUSSIA);
                    } else users.get(i).setCountry(User.Country.OTHER);
                    i++;
                }
                }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
