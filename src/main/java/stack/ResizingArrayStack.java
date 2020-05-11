package stack;

import java.util.Iterator;

/**
 * @author huangyb
 * @date 2020/5/10
 */
public class ResizingArrayStack<Item> implements Stack<Item> {

    private Item[] a;

    private int size;

    public ResizingArrayStack(int initialCapacity) {
        a = (Item[]) new Object[initialCapacity];
        size = 0;
    }

    public ResizingArrayStack() {
        this(16);
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public boolean push(Item data) {
        if (isFull()) {
            resize(2 * a.length);
        }
        a[size++] = data;
        return true;
    }

    @Override
    public Item pop() {
        Item item = a[--size];
        a[size] = null;
        if (size > 0 && a.length / 4 == size) {
            resize(a.length / 2);
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

    private boolean isFull() {
        return size == a.length;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i = size;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
        };
    }



}
