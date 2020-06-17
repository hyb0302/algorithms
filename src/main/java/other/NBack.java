package other;


import queue.Queue;
import queue.ResizingArrayQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author huangyb
 * @date 2020/6/15
 */
public class NBack {

    public static void main(String[] args) throws IOException {
        start(2);
    }

    private static void start(int n) throws IOException {
        Random random = new Random();
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new ResizingArrayQueue<>(n + 1);
        while (true) {
            int i = random.nextInt(10);
            System.out.println(i);
            queue.enqueue(i);
            System.out.println(queue.toString());
            String s = b.readLine();
            if ("exit".equals(s)) {
                break;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            if (queue.size() != n + 1) {
                continue;
            }
            Integer dequeue = queue.dequeue();
            if ("0".equals(s)) {
                System.out.println(dequeue.equals(i) ? "错误" : "正确");
            }
            if ("1".equals(s)) {
                System.out.println(dequeue.equals(i) ? "正确" : "错误");
            }

        }
    }
}
