package lvl2.hw3;

import java.text.MessageFormat;
import java.util.*;
import java.util.function.BiConsumer;

public class Phone {
   // public static ArrayList<HashSet> phones = new ArrayList<>();  е пойму как эту строку реализовать.
    public static ArrayList<String> Phone = new ArrayList<>();
    public static List<String> Name = new ArrayList<>();
    public static void add(String name,String phone){
        Name.add(name);
        Phone.add(phone);
    }
    public static void get(String name){
        System.out.println("");
       // String Hash =
        final int size = Phone.size();
        for(int i = 0; i<size; i++){
            System.out.println("Фамилия :" + Name.get(i)+" Номер :" + Phone.get(i));
        }
        System.out.println("\nПоиск по фамилии :" + name+"\n");
        for(int i = 0; i<size; i++){
            if (Name.get(i).equals(name)) {
                System.out.println("Фамилия :" + Name.get(i) + " Номер :" + Phone.get(i));
            }
        }
    }
}
