package com.tonyzhai.practise.date20202025;


import java.util.Stack;

public class LeetCode20 {

    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (!stack.isEmpty()) {
                Character previous = stack.peek();
                if ((current.equals('(') && previous.equals(')'))
                        || (current.equals(')') && previous.equals('('))
                        || (current.equals('[') && previous.equals(']'))
                        || (current.equals(']') && previous.equals('['))
                        || (current.equals('{') && previous.equals('}'))
                        || (current.equals('}') && previous.equals('{'))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode20().isValid("()"));
    }
}
