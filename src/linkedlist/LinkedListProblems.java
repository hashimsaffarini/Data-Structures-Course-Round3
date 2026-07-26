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

    static Node removeDuplicatesOneIteration(Node head) {
        if (head == null) return head;
        Node curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    static Node mergeAlternative(Node a, Node b) {
        Node dummy = new Node(0), tail = dummy;
        while (true) {
            if (a == null) {
                tail.next = b;
                break;
            } else if (b == null) {
                tail.next = a;
                break;
            } else {
                tail.next = a;
                tail = a;
                a = a.next;

                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        return dummy.next;
    }

    static Node sortedMerge(Node a, Node b) {
        Node dummy = new Node(0), tail = dummy;
        while (true) {
            if (a == null) {
                tail.next = b;
                break;
            } else if (b == null) {
                tail.next = a;
                break;
            } else {
                if (a.val <= b.val) {
                    tail.next = a;
                    tail = a;
                    a = a.next;
                } else {
                    tail.next = b;
                    tail = b;
                    b = b.next;
                }
            }
        }
        return dummy.next;
    }

    static Node sortedMergeArray(Node[] arr) {
        Node res = sortedMerge(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            res = sortedMerge(res, arr[i]);
        }
        return res;
    }

    static Node sortedIntersection(Node a, Node b) {
        Node dummy = new Node(0), tail = dummy;
        while (a != null && b != null) {
            if (a.val == b.val) {
                tail.next = new Node(a.val);
                tail = tail.next;
                a = a.next;
                b = b.next;
            } else if (a.val < b.val) {
                a = a.next;
            } else {
                b = b.next;
            }
        }
        return dummy.next;
    }

    static Node findKthNode(Node head, int k) {
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        if (k > size) {
            return null;
        }
        curr = head;
        for (int i = 0; i < size - k; i++) {
            curr = curr.next;
        }
        return curr;
    }

    static Node removeLocalPeaks(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node prev = head, curr = head.next;
        while (curr.next != null) {
            if (curr.val > prev.val && curr.val > curr.next.val) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;
        Node a = headA, b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

    static Node removeFromNToM(Node head, int n, int m) {
        if (head == null) return head;

        Node curr = head, curr1 = null, curr2 = null;
        for (int i = 0; curr != null; i++) {
            if (i == n - 1) {
                curr1 = curr;
            }
            if (i == m) {
                curr2 = curr;
            }
            curr = curr.next;
        }
        if (curr1 != null && curr2 != null) {
            curr1.next = curr2.next;
        }
        return head;
    }

    static Node swapNodes(Node head, int index1, int index2) {
        if (head == null || index1 == index2 || index1 < 0 || index2 < 0) {
            return head;
        }
        if (index1 > index2) {
            int temp = index1;
            index1 = index2;
            index2 = temp;
        }
        Node prev1 = null, node1 = head;
        for (int i = 0; i < index1 && node1 != null; i++) {
            prev1 = node1;
            node1 = node1.next;
        }
        Node prev2 = null, node2 = head;
        for (int i = 0; i < index2 && node2 != null; i++) {
            prev2 = node2;
            node2 = node2.next;
        }
        if (node1 == null || node2 == null) return head;
        if (node1.next == node2) {
            if (prev1 != null) {
                prev1.next = node2;
            } else {
                head = node2;
            }
            node1.next = node2.next;
            node2.next = node1;
            return head;
        }
        if (prev1 != null) {
            prev1.next = node2;
        } else {
            head = node2;
        }
        prev2.next = node1;
        Node temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
        return head;
    }

    static Node swapPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = head.next;
        Node prev = null, curr = head;
        while (curr != null && curr.next != null) {
            Node next = curr.next;
            curr.next = next.next;
            next.next = curr;
            if (prev != null) {
                prev.next = next;
            }
            prev = curr;
            curr = curr.next;
        }
        return newHead;
    }

    static Node removeDuplicatesWithoutDS(Node head) {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i; j.next != null; ) {
                if (i.val == j.next.val) {
                    j.next = j.next.next;
                } else {
                    j = j.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        /// 2 5 3 7 6 8 4
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(6);
        list.add(8);
        list.add(4);
        list.head = removeLocalPeaks(list.head);
        System.out.println(list);

    }
}
