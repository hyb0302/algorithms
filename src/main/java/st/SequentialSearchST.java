package st;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangyb
 * @date 2020/7/29
 */
public class SequentialSearchST<Key, Value> {

    private Node first;



    public void put(Key k, Value v) {
        if (k == null) {
            return;
        }

        for (Node n = first; n != null ; n = n.next) {
            if (k.equals(n.key)) {
                n.value = v;
                return;
            }
        }
        first = new Node(k, v, first);
    }

    public Value get(Key k) {
        if (k == null) {
            return null;
        }
        Node n = first;
        while (n != null && !k.equals(n.key)) {
            n = n.next;
        }

        return n == null ? null : n.value;
    }

    public int size() {
        Node n = first;
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;

    }

    public Set<Key> keys() {
        Set<Key> keys = new HashSet<>();
        for (Node n = first; n != null; n = n.next) {
            keys.add(n.key);
        }
        return keys;
    }


    public void delete(Key k) {
        if (k == null) {
            return;
        }
        if (first != null && first.key.equals(k)) {
            first = first.next;
            return;
        }
        for (Node n = first; n != null && n.next != null; n = n.next) {
            if (n.next.key.equals(k)) {
                n.next = n.next.next;
                return;
            }
        }
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
