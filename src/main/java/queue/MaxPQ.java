package queue;


import java.util.Arrays;

/**
 * @author huangyb
 * @date 2020/7/26
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;

    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public void sink(int n) {
        while (2 * n <= N) {
            int j = 2 * n;
            if (2 * n < N && less(pq[2 * n], pq[2 * n + 1])) {
                j++;
            }
            if (less(pq[j], pq[n])) {
                break;
            }
            exch(j, n);
            n = j;
        }
    }

    public void swim(int n) {
        while (n > 1 && less(pq[n / 2], pq[n])) {
            exch(n / 2, n);
            n = n / 2;
        }

    }

    public void insert(Key k) {
        if (N + 1 == pq.length) {
            return;
        }
        pq[++N] = k;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean less(Key k1, Key k2) {
        return k1.compareTo(k2) < 0;
    }

    @Override
    public String toString() {
        return "MaxPQ{" +
                "pq=" + Arrays.toString(pq) +
                '}';
    }

    public static void main(String[] args) {
        MaxPQ<Integer> i = new MaxPQ<>(7);
        i.insert(3);
        System.out.println(i);
        i.insert(4);
        System.out.println(i);
        i.insert(1);
        System.out.println(i);
        i.insert(2);
        System.out.println(i);
        i.insert(6);
        System.out.println(i);
        i.insert(5);
        System.out.println(i);
        i.insert(7);
        System.out.println(i);
        System.out.println("del: " + i.delMax());
        System.out.println(i);
        System.out.println("del: " + i.delMax());
        System.out.println(i);
        System.out.println("del: " + i.delMax());
        System.out.println(i);
        //null, 8, 7, 6, 5, 3, 2, 1
    }
}
