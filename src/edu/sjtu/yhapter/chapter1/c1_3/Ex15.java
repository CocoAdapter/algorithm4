package edu.sjtu.yhapter.chapter1.c1_3;

import stdlib.Queue;

import java.util.Stack;

/**
 * If allowing self-implemented Queue class,
 * use a loop-queue with size k supporting index, then
 * the space complexity is much lower
 *
 * Created by Yhapter on 2018/10/11.
 */
public class Ex15 {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        for (int i = 0; i < 20; i++)
            queue.enqueue("input " + i);
        System.out.println(func(queue, 4));
    }

    private static Object func(Queue queue, int k){
        Stack stack = new Stack<>();
        queue.forEach(stack::add);
        Object ans = null;
        for (int i = 0; i < k; i++)
            ans = stack.pop();
        return ans;
    }
}
