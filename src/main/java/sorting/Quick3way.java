package sorting;

import java.util.Arrays;

/**
 * @author huangyb
 * @date 2020/6/17
 */
public class Quick3way extends AbstractSort {

    public static final Quick3way INSTANCE = new Quick3way();

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    // 5,4,6,8,1,2
    // l         h
    // lt,i,     gt
    // 4,5,6,8,1,2
    //   lt,i
    // 4,5,2,8,1,6

    private void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int lt = low;
        int gt = high;
        int i = low + 1;
        Comparable v = a[low];

        while (i <= gt) {
            int compare = v.compareTo(a[i]);
            if (compare > 0) {
                exchange(a, lt++, i++);
            } else if (compare < 0) {
                exchange(a, gt--, i);
            } else {
                i++;
            }
            System.out.println(Arrays.toString(a) + "  lt:" + lt + ", i:" + i + ", gt:" + gt);
        }
        System.out.println();
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
    }

    public static void main(String[] args) {
        Integer[] generate = RandomArray.generate(6);
        System.out.println(Arrays.toString(generate));
        INSTANCE.sort(generate);
        System.out.println(Arrays.toString(generate));
    }
}
