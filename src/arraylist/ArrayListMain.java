package arraylist;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListMain {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10, 20, 30, 40, 50);
        list.add(10);
        list.add(20);
        System.out.println(list.size());
        System.out.println(list);
    }
}
