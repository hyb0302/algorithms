package sorting;

import java.util.Arrays;

/**
 * @author huangyb
 * @date 2020/6/14
 */
public class Quick extends AbstractSort {

    public static final Quick INSTANCE = new Quick();

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }


    private int partition(Comparable[] a, int low, int high) {

        Comparable v = a[low];

        int i = low;
        int j = high + 1;

        while (true) {
            while (less(a[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }

    private int partition2(Comparable[] a, int low, int high) {
        Comparable v = a[high];
        int i = low;
        int j = low;
        while (j < high) {
            if (less(a[j], v)) {
                exchange(a, j, i);
                i++;
            }
            j++;
        }
        exchange(a, high, i);
        return i;
    }

    public static void main(String[] args) {
        Comparable[] comparables = Arrays.asList(5, 3, 7, 8, 10).toArray(new Comparable[0]);

        Quick.INSTANCE.partition2(comparables,0, 4);

        System.out.println(Arrays.toString(comparables));

    }
}
