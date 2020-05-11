package stack;

import java.util.Iterator;

/**
 * @author huangyb
 * @date 2020/5/10
 */
public class LinkedListStack<Item> implements Stack<Item> {

    private Node first;

    private int size;

    private class Node {
        private Item item;
        private Node next;
    }

    @Override
    public boolean push(Item data) {
        Node oldFirst = first;
        first = new Node();
        first.item = data;
        first.next = oldFirst;
        size++;
        return true;
    }

    @Override
    public Item pop() {
        Item item = first.item;
        first = first.next;
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
        Stack<String> stack = new LinkedListStack<>();
        stack.push("1");
        stack.push("2");
        stack.pop();
        stack.push("3");
        for (String s : stack) {
            System.out.println(s);
        }
    }
}
