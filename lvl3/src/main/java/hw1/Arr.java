package hw1;

import java.io.Serializable;

public class Arr<E extends Object & Comparable<E> & Serializable>{


    private E[] data;
    private int currentSize;


    public Arr(int size) {

        this.data = (E[]) new Object[size];
    }

    public E get(int index) {

        return data[index];
    }

    public void add(E value) {

        add(value, currentSize);
    }

    public void add(E value, int index) {
        data[index] = value;
        currentSize++;
    }


    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }


    public void display() {
        for (Object datum : data) {
            System.out.println(datum + " ");
        }
        System.out.println();
    }


    public int getCurrentSize() {
        return currentSize;
    }

    public void exchange(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
