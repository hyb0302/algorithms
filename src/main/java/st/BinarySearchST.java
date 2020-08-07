package st;


import org.omg.CORBA.Object;

import java.util.Arrays;


/**
 * @author huangyb
 * @date 2020/7/30
 * key 不能为 null
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;

    private Value[] values;

    private int N = 0;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        int rank = rank(key);
        return keys[rank].compareTo(key) == 0 ? values[rank] : null;
    }

    public void put(Key key, Value value) {
        int rank = rank(key);

        if (keys[rank].compareTo(key) == 0 && rank < N) {
            values[rank] = value;
            return;
        }
        if (N == keys.length) {
            return;
        }
        for (int i = N; i > rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[rank] = key;
        values[rank] = value;
        N++;
    }

    public int rank(Key key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp > 0) {
                low = mid + 1;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public void delete(Key key) {
        int rank = rank(key);
        if (keys[rank].compareTo(key) != 0) {
            return;
        }
        for (int i = rank; i < N; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }


    public Key ceiling(Key key) {
        return keys[rank(key)];
    }

    public Key floor(Key key) {
        int rank = rank(key);
        return keys[rank].compareTo(key) == 0 ? keys[rank] : rank == 0 ? null : keys[rank - 1];
    }

    public Iterable<Key> keys() {
        return Arrays.asList(keys);
    }

}
