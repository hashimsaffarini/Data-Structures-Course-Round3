package stack;

import java.util.Stack;

public class StackProblems {

    static boolean isContains(Stack<Integer> s, int val) {
        while (!s.isEmpty()) {
            if (s.pop() == val) {
                return true;
            }
        }
        return false;
    }

    static void swapBetweenTopAndBottom(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        int top = a.pop();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        int bottom = b.pop();
        a.push(top);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
        a.push(bottom);
    }

    static void rotateFromTopToBottom(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        int top = a.pop();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        a.push(top);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    static void addBottom(Stack<Integer> a, int val) {
        Stack<Integer> b = new Stack<>();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        a.push(val);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    static boolean checkParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (ch == ')' && last != '(' || ch == '}' && last != '{' || ch == ']' && last != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean isPalindrome(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        int c = 0;
        while (!a.isEmpty()) {
            c++;
            b.push(a.pop());
        }
        for (int i = 0; i < c / 2; i++) {
            a.push(b.pop());
        }
        if (c % 2 != 0) {
            b.pop();
        }
        while (!a.isEmpty()) {
            if (a.pop() != b.pop()) return false;
        }
        return true;
    }

    static void sortStack(Stack<Integer> s) {
        Stack<Integer> t = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!t.isEmpty() && temp > t.peek()) {
                s.push(t.pop());
            }
            t.push(temp);
        }
        while (!t.isEmpty()) {
            s.push(t.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        swapBetweenTopAndBottom(s);
        System.out.println(s);
        /// while
//        while (!s.isEmpty()) {
//            int x = s.pop();
//            System.out.println(x);
//            s2.push(x);
//        }
//        while (!s2.isEmpty()) {
//            s.push(s2.pop());
//        }
//        System.out.println(s);

    }
}
