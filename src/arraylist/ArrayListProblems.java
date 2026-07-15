package arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListProblems {

    static void rotateFromLeftToRight(ArrayList<Integer> list) {
        list.add(list.remove(0));
    }

    static void rotateFromRightToLeft(ArrayList<Integer> list) {
        list.add(0, list.remove(list.size() - 1));
    }

    static void removeAllElements(ArrayList<Integer> list, int val) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == val) {
                list.remove(i);
                i--;
            }
        }
    }

    static void removeAllElements2(ArrayList<Integer> list, int val) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == val) {
                list.remove(i);
            }
        }
    }

    static ArrayList<Integer> removeAllDuplicates(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int val : a) {
            if (!res.contains(val)) {
                res.add(val);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 2, 10, 10, 30, 10, 5));
        removeAllElements(list, 10);
        System.out.println(list);
    }
}
