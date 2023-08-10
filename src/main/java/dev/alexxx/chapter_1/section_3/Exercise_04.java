package dev.alexxx.chapter_1.section_3;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Exercise_04 {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            Character str = StdIn.readChar();
            switch (str) {
                case '{', '[', '(' -> stack.push(str);
                default -> {
                    if (stack.isEmpty()) {
                        System.out.println(false);
                        return;
                    }
                    Character pop = stack.pop();
                    boolean bool = switch (pop) {
                        case '{' -> str.equals('}');
                        case '[' -> str.equals(']');
                        case '(' -> str.equals(')');
                        default -> false;
                    };
                    if (!bool) {
                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        System.out.println(stack.isEmpty());
    }

}