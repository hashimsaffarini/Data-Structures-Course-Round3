package linkedlist;

public class CircularLinkedList {

    static void printLinkedList(Node head) {
        Node curr = head;
        do {
            System.out.print(curr.val + " ");
            curr = curr.next;
        } while (curr != head);
    }

    static int countNodes(Node n) {
        Node curr = n;
        int c = 0;
        do {
            c++;
            curr = curr.next;
        } while (curr != n);
        return c;
    }

    static Node removeFirstElement(Node head) {
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = head.next;
        head = curr.next;
        return head;
    }

    static Node removeLastElement(Node head) {
        Node curr = head;
        while (curr.next.next != head) {
            curr = curr.next;
        }
        curr.next = head;
        return head;
    }

    static int countNodesInLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return countNodes(slow);
        }
        return 0;
    }

    static Node swapFirstAndLastItems(Node head) {
        if (head == null || head.next == head)
            return head;

        if (head.next.next == head) {
            head = head.next;
            return head;
        }

        Node cur = head;

        while (cur.next.next != head)
            cur = cur.next;

        cur.next.next = head.next;
        head.next = cur.next;
        cur.next = head;
        head = head.next;

        return head;
    }

    public static void main(String[] args) {

    }
}
