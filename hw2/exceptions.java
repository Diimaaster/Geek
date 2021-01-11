package lvl2.hw2;

public class exceptions {
    static public void main(String[] args) throws MyArrayDataException {
        String[][] arr = {
                {"1", "2", "7","3"},
                {"2", "3", "9", "3"},
                {"7", "0", "7", "4"},
                {"6", "1", "5","5"}
        };
        func(arr);
    }
    public static void func(String[][] arr) throws MyArrayDataException {
        final int CHECK = 4;
        int sum = 0;

            for(int i=0; i<CHECK;i++){
                if((arr.length!=arr[i].length)&&(arr[i].length!=CHECK)){
                    throw new MyArraySizeException();//тут все понятно программа дальше не выполняется, так как мы бросили ошибку.
                }
                for(int j=0; j<CHECK;j++){
                    try {
                        sum+=Integer.parseInt(arr[i][j]);
                    }catch (Exception e){
                        System.out.println("В ячейке с индексами ["+(i+1)+"]["+(j+1)+"] содержится не верный символ");
                        throw new MyArrayDataException();///Тут вся загвостака во 1, почему в catch мы не можем нашу ошибку указать?
                                                        /// из-за того чтио мы именно бросаем ошибку , а не просто ее выводим на экран,
                                                       // у нас программа завершается сразу как только находит первый не верный символ
                    }
                }
            }
        System.out.println("Cумма : " + sum); // так ,ну тут все норм,но только в случаях
                                              //когда у нас нет символов .Суть этой дз ,если я правильно понял,
                                              // чтобы не смотря на то какой размер массива и не смотря на то ,
                                             // что там могут быть символы ,он все равно должен считать сумму
    }

}
/*
for(int i=0; i<CHECK;i++){
        if((arr.length!=arr[i].length)&&(arr[i].length!=CHECK)){
        throw new MyArraySizeException();
        }
        for(int j=0; j<CHECK;j++){
        try {
        sum+=Integer.parseInt(arr[i][j]);
        }catch (Exception e){
        System.out.println("В ячейке с индексами ["+(i+1)+"]["+(j+1)+"] содержится не верный символ");
        e.printStackTrace();
        }
        }
        }
        System.out.println("Cумма : " + sum);
        если писать эту программу через существующие ошибки то все норм работает.
        то есть заменить наши кассы на стандартные ArrayIndexOutOfBoundsException и NumberFormatException
         тогда программа не будет останавливаться


         остановку в строке 19 я понимаю но вот со строчки 24 начинается что-то страное...
         программа вроде вообще не сложная но почему-то что-то не то.
        */
