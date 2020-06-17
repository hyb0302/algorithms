package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huangyb
 * @date 2020/5/11
 */
public class ResizingArrayQueue<Item> implements Queue<Item> {

    private Item[] a;

    private int size;

    private int head;

    private int tail;

    private int initialCapacity;

    public ResizingArrayQueue() {
        this(16);
    }

    public ResizingArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        a = (Item[]) new Object[capacity];
        size = 0;
        head = 0;
        tail = 0;
        initialCapacity = capacity;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        int i1 = 0;
        int i2 = head;
        for (int count = size; count > 0; count--) {
            temp[i1] = a[i2 % a.length];
            i1++;
            i2++;
        }
        head = 0;
        tail = size;
        System.out.println("capacity: " + a.length + " -> " + temp.length);
        a = temp;
    }

    @Override
    public boolean enqueue(Item item) {
        if (a.length == size) {
            resize(2 * a.length);
        }
        a[tail] = item;
        tail = (tail + 1) % a.length;
        size++;
        return true;
    }

    @Override
    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        if (size >= initialCapacity && a.length / 4 >= size) {
            resize(a.length / 2);
        }
        Item item = a[head];
        a[head] = null;
        head = (head + 1) % a.length;
        size--;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i = size;
            private int h = head;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                Item item = a[h];
                i--;
                h = (h + 1) % a.length;
                return item;
            }
        };
    }

    @Override
    public String toString() {
        return Arrays.stream(a).collect(Collectors.toList()).toString();
    }

    public static void main(String[] args) {
        Queue<String> queue = new ResizingArrayQueue<>(2);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");

        for (String s : queue) {
            System.out.println(s);
        }
    }
}
