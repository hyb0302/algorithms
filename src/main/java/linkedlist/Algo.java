package linkedlist;

import com.sun.istack.internal.NotNull;

/**
 * @author huangyb
 * @date 2020/4/17
 */
public class Algo {

    public static <T extends Comparable<T>> LinkedList<T> sortedMerge(@NotNull LinkedList<T> l1, @NotNull LinkedList<T> l2, boolean descending) {
        LinkedList<T> result = new LinkedList<T>();

        LinkedList.Node<T> h1 = l1.getHead();
        LinkedList.Node<T> h2 = l2.getHead();

        while (h1 != null && h2 != null) {
            int r = descending ? h1.getData().compareTo(h2.getData()) * -1 : h1.getData().compareTo(h2.getData());
            if (r < 0) {
                result.add(h1.getData());
                h1 = h1.getNext();
            } else if (r > 0) {
                result.add(h2.getData());
                h2 = h2.getNext();
            } else {
                result.add(h1.getData());
                h1 = h1.getNext();
            }
        }
        LinkedList.Node<T> t;
        if (h1 != null) {
            t = h1;
        } else if (h2 != null) {
            t = h2;
        } else {
            return result;
        }

        while (t != null) {
            result.add(t.getData());
            t = t.getNext();
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.add(2);
        l1.add(5);
        l1.add(7);
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l2.add(1);
        l2.add(2);
        l2.add(8);

        System.out.println(sortedMerge(l1, l2, false).toString());

    }
}
