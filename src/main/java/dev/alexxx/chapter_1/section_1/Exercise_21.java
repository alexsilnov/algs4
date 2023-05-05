package dev.alexxx.chapter_1.section_1;


import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_21 {

    public static void main(String[] args) {
        List<String> formattedRows = formatRows(parseRows(readRows(System.in)));
        formattedRows.forEach(System.out::println);
    }

    private static List<String> readRows(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        List<String> rows = new ArrayList<>();
        while (scanner.hasNext()) {
            rows.add(scanner.nextLine());
        }
        return rows;
    }

    private static List<Triple<String, Integer, Integer>> parseRows(List<String> rows) {
        List<Triple<String, Integer, Integer>> tripleList = new ArrayList<>();
        for (String row : rows) {
            String[] splitRow = row.split(" ");
            tripleList.add(new ImmutableTriple<>(splitRow[0], Integer.parseInt(splitRow[1]), Integer.parseInt(splitRow[2])));
        }
        return tripleList;
    }

    private static List<String> formatRows(List<Triple<String, Integer, Integer>> tripleList) {
        List<String> formattedRows = new ArrayList<>();
        for (Triple<String, Integer, Integer> triple : tripleList) {
            formattedRows.add(String.format("%s %d %d %3f",
                    triple.getLeft(),
                    triple.getMiddle(),
                    triple.getRight(),
                    triple.getMiddle().doubleValue() / triple.getRight().doubleValue()
                )
            );
        }
        return formattedRows;
    }
}