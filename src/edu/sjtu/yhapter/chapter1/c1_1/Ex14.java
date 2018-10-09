package edu.sjtu.yhapter.chapter1.c1_1;

/**
 * Created by Yhapter on 2018/10/9.
 */
public class Ex14 {
    public static void main(String[] args) {
        System.out.println(lg(1));
    }

    public static int lg(int N){
        if (N < 1)
            return -1;
        
        int e = 1;
        int tem = 2;
        while (tem <= N){
            tem <<= 1;
            e++;
        }
        return e - 1;
    }
}
