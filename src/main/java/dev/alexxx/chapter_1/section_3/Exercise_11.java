package dev.alexxx.chapter_1.section_3;


import edu.princeton.cs.algs4.Stack;

public class Exercise_11 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        String s1 = "4 2 + 1 3 - *";
        String[] str = s1.split("\\s");
        for (String s : str) {
            switch (s) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "-" -> stack.push(- stack.pop() + stack.pop());
                default -> stack.push(Integer.parseInt(s));
            }
        }
        System.out.println(stack.pop());
    }

}