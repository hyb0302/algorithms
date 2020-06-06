package sort;

/**
 * @author huangyb
 * @date 2020/6/4
 */
public class Example {

    public static void sort(Comparable[] a) {

    }

    private static boolean less(Comparable p, Comparable n) {
        return p.compareTo(n) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }
}
