package sorting;

/**
 * @author huangyb
 * @date 2020/6/7
 */
public class Insertion extends AbstractSort {

    public static final Insertion INSTANCE = new Insertion();

    private Insertion() {
    }

    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
}
