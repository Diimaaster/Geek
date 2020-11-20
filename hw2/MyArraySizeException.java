package lvl2.hw2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException(){
        super("Проверьте размер массива");
    }
}
