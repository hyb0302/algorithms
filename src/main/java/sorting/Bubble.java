package sorting;

import java.util.Arrays;

/**
 * @author huangyb
 * @date 2020/8/2
 */
public class Bubble extends AbstractSort {
    @Override
    public void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    exchange(a, j + 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] generate = RandomArray.generate(5);
        System.out.println(Arrays.toString(generate));
        new Bubble().sort(generate);
        System.out.println(Arrays.toString(generate));
    }
}
