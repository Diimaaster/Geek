package lvl2.hw5;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] a2 = new float[h];
    static float[] a1 = new float[h];
    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        firstVoid(arr);
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        secondVoid(arr);
    }
    public static void firstVoid(float[] arr){
        System.out.println("Изменение массивы целиком на прямую");
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }
    public static void secondVoid(float[] arr){
        System.out.println("\nИзменение массива с помощю разбиения его на 2 части");
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        },"1 - я  часть ");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        },"2 - я  часть ");
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }
}
