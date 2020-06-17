package sorting;

/**
 * @author huangyb
 * @date 2020/6/14
 */
public class MergeBU extends AbstractSort {

    public static final MergeBU INSTANCE = new MergeBU();

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        //a.length = 16
        // 1,2,4,8
        for (int sz = 1; sz < a.length; sz = sz + sz) {
            // 1/15: 0,2,4,6,8,10,12,14
            // 2/14: 0,4,8,12
            // 4/12: 0,8
            // 8/8:  0
            for (int lo = 0; lo < a.length - sz; lo = lo + sz + sz) {
                // 0,0,1 | 2,2,3 | 4,4,5 | 6,6,7 | 8,8,9 | 10,10,11 | 12,12,13 | 14,14,15
                // 0,1,3 | 4,5,8 | 8,9,11 | 12,13,15
                // 0,3,7 | 8,11,15
                // 0,7,15
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
            }
        }
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(a[j], a[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }
}
