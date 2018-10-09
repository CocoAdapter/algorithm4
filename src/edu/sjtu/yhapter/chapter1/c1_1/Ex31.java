package edu.sjtu.yhapter.chapter1.c1_1;

import stdlib.StdDraw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Created by Yhapter on 2018/10/9.
 */
public class Ex31 {
    private static final double cx = 0.5;
    private static final double cy = 0.5;
    private static final double r = 0.45;

    public static void main(String[] args) throws IOException {
        StdDraw.show();
        System.in.read();
        StdDraw.circle(cx, cy, r);
        func(200, 0.15);
    }

    private static void func(int N, double p) {
        List<Point> pointList = new ArrayList<>();

        double perRadius = Math.PI * 2 / N;
        double tem = 0;

        Random random = new Random(System.currentTimeMillis());
        while (tem < Math.PI * 2) {
            double x = cx + Math.sin(tem) * r;
            double y = cy + Math.cos(tem) * r;

            Point newP = new Point(x, y);

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius(0.01);
            StdDraw.point(x, y);
            // 边画点边连线
            pointList.parallelStream().forEach(oldP -> {
                double probability = random.nextDouble();
                if (probability <= p) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    StdDraw.setPenRadius(0.002);
                    StdDraw.line(oldP.x, oldP.y, newP.x, newP.y);
                }
            });
            pointList.add(newP);

            tem += perRadius;
        }

        // 画完点后连线
//        for (int i = 0; i < pointList.size(); i++) {
//            Point oldP = pointList.get(i);
//            pointList.parallelStream().filter(point -> point != oldP).parallel().forEach(newP -> {
//                double probability = random.nextDouble();
//                if (probability <= p) {
//                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
//                    StdDraw.setPenRadius(0.002);
//                    StdDraw.line(oldP.x, oldP.y, newP.x, newP.y);
//                }
//            });
//        }
    }

    private static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
