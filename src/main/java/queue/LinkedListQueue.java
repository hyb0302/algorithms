package queue;

import java.util.Iterator;

/**
 * @author huangyb
 * @date 2020/5/10
 */
public class LinkedListQueue<Item> implements Queue<Item> {

    private Node first;

    private Node last;

    private int size;

    private class Node {
        private Item item;
        private Node next;
    }

    @Override
    public boolean enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public Item dequeue() {
        if (first == null) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
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
            private Node current = first;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                i--;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedListQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.dequeue();
        queue.enqueue("3");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("4");
        queue.enqueue("5");
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
