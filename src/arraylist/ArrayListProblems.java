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

    static boolean isPalindrome(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    static void reverse(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            list.set(i, list.set(list.size() - 1 - i, list.get(i)));
        }
    }

    static boolean isPrime(int x) {
        if (x <= 1) return false;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    static void swapPrimesToEnd(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (isPrime(list.get(i))) {
                list.add(list.remove(i));
            }
        }
    }

    static boolean contains(ArrayList<Integer> list, int val) {
        for (int v : list) {
            if (v == val) return true;
        }
        return false;
    }

    static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int val : a) {
            if (contains(b, val) && !contains(res, val)) {
                res.add(val);
            }
        }
        return res;
    }

    static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int val : a) {
            if (!res.contains(val)) {
                res.add(val);
            }
        }
        for (int val : b) {
            if (!res.contains(val)) {
                res.add(val);
            }
        }
        return res;
    }

    static void removeNElements(ArrayList<Integer> list, int start, int numbers) {
        for (int i = 0; i < numbers; i++) {
            list.remove(start);
        }
    }

    static void removeFromIndexToIndex(ArrayList<Integer> list, int start, int end) {
        for (int i = end; i >= start; i--) {
            list.remove(i);
        }
    }

    static ArrayList<ArrayList<Integer>> generatePascal(int rows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a.add(1);
                } else {
                    a.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(a);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(generatePascal(6));

    }
}
