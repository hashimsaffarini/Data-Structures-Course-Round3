package linkedlist;

public class LinkedListMain {



    static void fun (Node head){
    }


    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(50);
        System.out.println(list.get(1));
        System.out.println(list);
    }
}
