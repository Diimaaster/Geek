package hw1;

import java.io.Serializable;
import java.lang.reflect.Array;

public class hw1 {
    public static Arr<String> Arrayy = new Arr<String>(3);
    public static void main(String[] args) {

        Arrayy.display();
        Arrayy.add("A");
        Arrayy.add("B");
        Arrayy.add("C");
        change(0,1);
        System.out.println();
        Arrayy.display();

    }

    private static void change(int i, int i1) {
        Arrayy.exchange(i, i1);
        //по сути этот метод итак был реализован на уроке
        //я просто 1 метод запихнул еще в 1
    }
}
