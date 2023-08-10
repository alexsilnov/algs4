package dev.alexxx.chapter_1.section_3;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Exercise_09 {
    public static void main(String[] args) {
        Stack<String> values = new Stack<>();
        Stack<String> operation = new Stack<>();
        String[] str = StdIn.readAll().split("\\s");
        for (String s : str) {
            switch (s) {
                case "+", "-", "*" -> operation.push(s);
                case ")" -> {
                    String val2 = values.pop();
                    String val1 = values.pop();
                    String subValue = "(" + val1 + operation.pop() + val2 + ")";
                    values.push(subValue);
                }
                default -> values.push(s);
            }
        }
        System.out.println(values.pop());
    }

}