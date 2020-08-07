package sorting;

import java.util.Arrays;

/**
 * @author huangyb
 * @date 2020/8/7
 */
public class Counting {

    public static void sort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }
        int[] sorted = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            sorted[count[a[i]] - 1] = a[i];
            count[a[i]]--;
        }

        for (int i = 0; i < sorted.length; i++) {
            a[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] i = {5, 7, 4, 5, 4, 8, 1, 2, 1, 2, 3};
        sort(i);
        System.out.println(Arrays.toString(i));
    }
}
