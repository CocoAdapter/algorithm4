package edu.sjtu.yhapter.chapter1.c1_1;

/**
 * Created by Yhapter on 2018/10/9.
 */
public class Ex20 {
    public static void main(String[] args) {
        System.out.println(func(0));
    }

    public static double func(int N){
        if (N < 1)
            throw new RuntimeException("N < 1");

        if (N == 1)
            return 0;

        return Math.log(N) + func(N - 1);
    }
}
