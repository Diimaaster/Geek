package hw4;

import java.util.concurrent.atomic.AtomicBoolean;

import static java.awt.PageAttributes.MediaType.A;


public class Hw4 {
    public int count = 3;

    public void ABC() {
        Thread A = new Thread(() -> {
                if (count % 3 == 0) {
                    System.out.print("A");
                    count++;
                    notify();
                } else {
                    try {
                        wait();
                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });
        Thread B = new Thread(() -> {

            if (count % 4 == 0) {
                System.out.print("B");
                count++;
                notify();
            } else {
                try {
                    wait();
                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread C = new Thread(() -> {

            if (count % 5 == 0) {
                System.out.print("C");
                count++;
                notify();
            } else {
                try {
                    wait();
                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


static class Main {

    public static void main(String[] args) {
        Hw4 o1 = new Hw4();
        new Thread(o1::ABC).start();
    }

}
}