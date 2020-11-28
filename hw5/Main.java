package lvl2.hw5;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] a2 = new float[h];
    static float[] a1 = new float[h];
    static long time1,time2,time;
    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        firstVoid(arr);
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        System.out.println("\nИзменение массива с помощю разбиения его на 2 части");
        secondVoid(arr);
    }
    public static void firstVoid(float[] arr){
        System.out.println("Изменение массива целиком на прямую");
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }
    public static void secondVoid(float[] arr){
        time = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(() -> {
            time1 = System.currentTimeMillis();
            for (int i = 0; i < h; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            time1 = (System.currentTimeMillis() - time1);
            System.out.println("Замена 1-ой части прошла успешно. Потрачено: " + time1);
        },"1 - я  часть ");
        Thread t2 = new Thread(() -> {
            time2 = System.currentTimeMillis();
            for (int i = 0; i < h; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            time2 = (System.currentTimeMillis() - time2);
            System.out.println("Замена 2-ой части прошла успешно. Потрачено: " + time2);
        },"2 - я  часть ");
        t1.start();
        t2.start();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Время на разбиение массивов,а потом на их склейку : " + (System.currentTimeMillis() - time));
    }
}
//////////////// Не пойму почему сообщения о замене появляются после сообщения о времени .
//    по 2-ому методу выводит 3 замера времени. то,что больше и есть время выполнения 2-го метода так как они выполняются параллельно.
