package edu.sjtu.yhapter.chapter1.c1_1;

/**
 * Created by Yhapter on 2018/10/9.
 */
public class Ex24 {

    public static void main(String[] args) {
        System.out.println(gcd(16, 1));
    }

    // gcd(a, b) = gcd(b, a mod b) when a > b
    private static int gcd(int num1, int num2){
        System.out.println(String.format("p is:%8d, q is:%8d", num1, num2));
        if (num2 == 0)
            return num1;

        if (num1 > num2){
            return gcd(num2, num1 % num2);
        } else if (num1 < num2){
            return gcd(num1, num2 % num1);
        } else
            return num1;
    }
}
