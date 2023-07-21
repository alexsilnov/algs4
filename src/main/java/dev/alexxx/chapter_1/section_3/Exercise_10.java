package dev.alexxx.chapter_1.section_3;


import edu.princeton.cs.algs4.Stack;

public class Exercise_10 {
    public static void main(String[] args) {
        Stack<String> values = new Stack<>();
        Stack<String> operation = new Stack<>();
        String s1 = "( ( 1 + 2 ) * ( ( 3 - 4 ) * 5 - 6 ) ) )";
        String[] str = s1.split("\\s");
        for (String s : str) {
            switch (s) {
                case "(" -> {}
                case "+", "-", "*" -> operation.push(s);
                case ")" -> {
                    String val2 = values.pop();
                    String val1 = values.pop();
                    String subValue = val1 + val2 + operation.pop();
                    values.push(subValue);
                }
                default -> values.push(s);
            }
        }
        System.out.println(values.pop());
    }

}