package stack;


import java.util.Iterator;

/**
 * @author huangyb
 * @date 2020/5/10
 */
public class FixedCapacityStack<Item> implements Stack<Item> {

    private Item[] a;

    private int size;

    public FixedCapacityStack(int capacity) {

        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        a = (Item[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean push(Item data) {
        if (size == a.length) {
            return false;
        }
        a[size++] = data;
        return true;
    }

    @Override
    public Item pop() {
        if (size == 0) {
            return null;
        }
        return a[--size];
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
