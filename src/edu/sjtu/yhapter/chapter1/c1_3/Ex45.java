package edu.sjtu.yhapter.chapter1.c1_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Yhapter on 2018/10/11.
 */
public class Ex45 {

    public static void main(String[] args) {
        String input = "1 2 3 4 - - - - -";
        String input2 = "0 1 2 3 4 5 6 7 8 9";

//        System.out.println(func(input));
        System.out.println(func2("1 2 3 4", "1 4 2 3"));
//        System.out.println(func2(input2, "4 6 8 7 5 3 2 9 0 1"));
//        System.out.println(func2(input2, "9 8 7 6 5 4 3 2 1 0"));

        List<String> possibles = allPossibleOutputs("0 1 2 3 4 5 6 7 8 9");
        possibles.forEach(s -> {
            if (s.contains("4 3 2 1 0 9 8 7 6 5"))
                System.out.println("match true");
            else if (s.contains("4 6 8 7 5 3 2 9 0 1"))
                System.out.println("match false");
        });
    }

    /**
     *
     * @param input input string, like "1 2 3 4 - - -"
     * @return is stack-underflow safe
     */
    private static boolean func(String input){
        String[] inputs = input.split(" ");

        int count = 0;
        for (String s : inputs) {
            if (s.equals("-"))
                count--;
            else
                count++;

            if (count < 0)
                return false;
        }
        return true;
    }

    /**
     *
     * @param input input string, like "1 2 3 4"
     * @param output possible output string, like "4 3 2 1"
     * @return if the output
     */
    private static boolean func2(String input, String output){
        String[] inputs = input.split(" ");
        String[] outputs = output.split(" ");

        Stack<String> stack = new Stack<>();

        int i = 0, j = 0;
        while (i < outputs.length) {
            if (stack.isEmpty() || !stack.peek().equals(outputs[i])){
                if (j < inputs.length)
                    stack.push(inputs[j++]);
                else
                    break;
            } else {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }

    /**
     *
     * @param input the in-stack sequence
     * @return a list containing all possible out-stack sequences
     */
    private static List<String> allPossibleOutputs(String input){
        List<String> outputs = new ArrayList<>();

        String[] inputs = input.split(" ");
        Stack<String> queue = new Stack<>();
        Stack<String> tem = new Stack<>();
        Stack<String> stackOut = new Stack<>();
        // reverse-insert
        for (int i = inputs.length - 1; i >= 0; i--) {
            queue.push(inputs[i]);
        }

        func(outputs, queue, tem, stackOut);
        return outputs;
    }

    // Attention! inputs & outputs should be Stack to help recover
    private static void func(List<String> ans, Stack<String> inputs, Stack<String> newStack, Stack<String> outputs){
        // exit
        if (inputs.isEmpty() && newStack.isEmpty() && !outputs.isEmpty()){
            StringBuilder sb = new StringBuilder();
            outputs.forEach(s -> {
               sb.append(s).append(' ');
            });
//            System.out.println(sb.toString());
            ans.add(sb.toString());
            return;
        }

        if (!inputs.isEmpty()){ // push into stack
            String top = inputs.pop();
            newStack.push(top);
            func(ans, inputs, newStack,outputs);
            newStack.pop();
            inputs.push(top); // recover
        }

        if (!newStack.isEmpty()){ // pop out stack
            String top = newStack.pop();
            outputs.push(top);
            func(ans, inputs, newStack, outputs);
            // recover
            outputs.pop();
            newStack.push(top); // recover
        }
    }
}
