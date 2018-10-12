package edu.sjtu.yhapter.chapter1.c1_3;

import stdlib.Queue;

import java.io.File;

/**
 * Created by Yhapter on 2018/10/11.
 */
public class Ex43 {

    public static void main(String[] args) {
        File root = new File("C:\\Users\\CocoAdapter\\Desktop\\algorithm4");
        ll(root);
    }

    @SuppressWarnings("all")
    private static void func(Queue<File> files, int offset){
        while (!files.isEmpty()){
            File file = files.dequeue();
            for (int i = 0; i < offset; i++)
                System.out.print('-');
            System.out.println(file.getName());

            if (file.isDirectory()){
                for (File subFile : file.listFiles()) {
                    files.enqueue(subFile);
                    func(files, offset + 2);
                }
            }
        }
    }

    private static void ll(File root){
        Queue<File> files = new Queue<>();
        files.enqueue(root);
        func(files, 0);
    }
}
