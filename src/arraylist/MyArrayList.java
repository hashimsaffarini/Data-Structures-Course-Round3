package arraylist;

import java.util.Arrays;

public class MyArrayList<T> {
    private T arr[];
    private int size;

    MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    MyArrayList(int capacity) {
        arr = (T[]) new Object[capacity];
        size = 0;
    }

    void add(T val) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = val;
    }

    T set(int index, T val) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T oldValue = arr[index];
        arr[index] = val;
        return oldValue;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void clear() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    void resize() {
        T temp[] = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    int size() {
        return size;
    }

    T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return arr[index];
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += arr[i];
            if (i != size - 1) {
                s += ", ";
            }
        }
        return s + "]";
    }
}
