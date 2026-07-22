package linkedlist;

import java.util.ArrayList;

public class LinkedListProblems {

    static Node middle(Node head) {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static boolean isSortedLinkedList(Node head) {
        for (Node curr = head; curr.next != null; curr = curr.next) {
            if (curr.val > curr.next.val) return false;
        }
        return true;
    }

    static boolean isSortedAnyWay(Node head) {
        boolean f1 = true, f2 = true;
        for (Node curr = head; curr.next != null; curr = curr.next) {
            if (!f1 && !f2) return false;
            if (curr.val > curr.next.val) {
                f1 = false;
            } else if (curr.val < curr.next.val) {
                f2 = false;
            }
        }
        return f1 || f2;
    }

    static Node removeDuplicates(Node head) {
        ArrayList<Integer> res = new ArrayList<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            if (!res.contains(curr.val)) {
                res.add(curr.val);
            }
        }
        Node dummy = new Node(0);
        Node tail = dummy;
        for (int val : res) {
            tail.next = new Node(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = middle(head);
        Node secondHalf = reverse(mid);
        Node firstHalf = head;
        while (firstHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    static boolean checkCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    static Node insertSort(Node head, int val) {
        Node curr = head;
        Node newNode = new Node(val);
        if (head == null || head.val > val) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        while (curr.next != null) {
            if (curr.next.val > val) {
                break;
            }
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    static boolean isSame(Node headA, Node headB) {
        Node a = headA, b = headB;
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.head = reverse(list.head);
        System.out.println(list);
    }
}
