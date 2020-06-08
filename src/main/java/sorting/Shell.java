package sorting;

import java.util.Arrays;

/**
 * @author huangyb
 * @date 2020/6/7
 */
public class Shell extends AbstractSort {

    public static final Shell INSTANCE = new Shell();

    public static void main(String[] args) {
        Integer[] a = {5, 9, 10, 3, 7, 8, 2, 1};
        Shell.INSTANCE.sort(RandomArray.generate(15));
        System.out.println(Arrays.toString(a));
    }

    @Override
    public void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = h; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }

            h = h / 3;
        }
    }
}
