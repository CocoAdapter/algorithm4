package edu.sjtu.yhapter.chapter1.c1_1;

import java.util.Arrays;

/**
 * Created by Yhapter on 2018/10/9.
 */
public class Ex27 {
    private static Double[][] values;

    public static void main(String[] args) {
        System.out.println(binomial(10, 5, 0.32));
    }

    public static double binomial(int N, int k, double p){
        if (values == null)
            values = new Double[N + 1][k + 1];
        // b(N, k, p)
        if (N == 0 && k == 0)
            return 1;
        if (N < 0 || k < 0)
            return 0;


        if (N - 1 >= 0 && k - 1 >= 0){
            double p1, p2;

            if (values[N - 1][k - 1] == null){
                p1 = binomial(N - 1, k - 1, p);
                values[N - 1][k - 1] = p1;
            } else
                p1 = values[N - 1][k - 1];

            if (values[N - 1][k] == null){
                p2 = binomial(N - 1, k, p);
                values[N - 1][k] = p2;
            } else
                p2 = values[N - 1][k];

            return p * p1 + (1 - p) * p2;
        } else
            return p * binomial(N - 1, k - 1, p) + (1 - p) * binomial(N - 1, k, p);
    }
}
