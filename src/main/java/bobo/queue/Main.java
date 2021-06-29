package bobo.queue;

import java.util.Random;

public class Main {

    public static double testQueue(Queue<Integer> queue, int opCount) {
        final long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        final long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        System.out.println("ArrayQueue: " + testQueue(new ArrayQueue<>(), opCount));
        System.out.println("LoopQueue: " + testQueue(new LoopQueue<>(), opCount));
        System.out.println("LinkedListQueue: " + testQueue(new LinkedListQueue<>(), opCount));
    }
}
