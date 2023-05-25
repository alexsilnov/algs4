package dev.alexxx.chapter_1.section_1;


import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_31 {
    private static int CANVAS_WIDTH = 1000;

    public static void main(String[] args) {
        int n = StdIn.readInt();
        double p = StdIn.readDouble();
        setCanvas();
        double[][] points = getPoints(n);
        printDots(points);
        printLines(points, p);
    }

    private static void setCanvas() {
        StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_WIDTH);
        StdDraw.setXscale(0.0, CANVAS_WIDTH);
        StdDraw.setYscale(0.0, CANVAS_WIDTH);
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.GREEN);
    }

    private static void printDots(double[][] points) {
        for (int i = 0; i < points[0].length; i++) {
            StdDraw.point(points[0][i], points[1][i]);
        }
    }

    private static void printLines(double[][] pairs, double p) {
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < pairs[0].length - 1; i++) {
            for (int j = i + 1; j < pairs[0].length; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(pairs[0][i], pairs[1][i], pairs[0][j], pairs[1][j]);
                }
            }
        }
    }

    private static double[][] getPoints(int n) {
        double[][] points = new double[2][n];
        double canvasCenterX = CANVAS_WIDTH / 2.0;
        double canvasCenterY = CANVAS_WIDTH / 2.0;
        double angle = 2 * Math.PI / n;
        double radius = CANVAS_WIDTH / 4.0;
        for (int i = 0; i < n; i++) {
            points[0][i] = canvasCenterX + radius * Math.cos(angle * i);
            points[1][i] = canvasCenterY + radius * Math.sin(angle * i);
        }
        return points;
    }

}