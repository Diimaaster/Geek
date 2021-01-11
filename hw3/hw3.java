package lvl2.hw3;

import java.util.ArrayList;

public class hw3 {
    public static void main(String[] args){
        String[] arr = {"Апельсин","Яблоко","Банан","Банан","Абрикос","Апельсин","Вишня","Виноград","Томат","Картофель","Томат","Апельсин","Чеснок","Лук","Гранат","Манго"};
        System.out.print("[ ");
        int k;
        for(k = 0; k < arr.length ; k++){
            if(k!=arr.length-1){
                System.out.print(arr[k]+", ");
            }else{
                System.out.println(arr[k]+" ]");
            }
        }
        listwords(arr);
        Phone phone = new Phone();
        phone.add("Borisov","+79836421585");
        phone.add("Ivanov","+79361548672");
        phone.add("Ivanov","+79643618564");
        phone.add("Petrov","+79253794844");
        phone.add("Ivanov","+79643619384");
        phone.add("Romanov","+79851944462");
        phone.get("Ivanov");
    }
    public static void listwords(String[] arr){
        ArrayList<String> newArr = new ArrayList<>(20);
        int size = arr.length;
        for(int i = 0; i < size; i++){
            String word = arr[i];
            byte check = 0;
            for(int j=0;j<size;j++){
                if(word.equals(arr[j])){
                    check++;
                    if(check>1){
                        int j1;
                        for(j1=j;j1<size-1;j1++){
                            arr[j1]=arr[j1+1];
                        }
                        size--;
                        j--;
                    }
                }
            }
            newArr.add(arr[i]+" ("+check+")");
        }
        System.out.println(newArr);
    }
}
