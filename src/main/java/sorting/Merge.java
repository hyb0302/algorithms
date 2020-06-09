package sorting;

/**
 * @author huangyb
 * @date 2020/6/9
 */
public class Merge extends AbstractSort {

    public static final Merge INSTANCE = new Merge();

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    //0,3
    //0,1
    //2,3
    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        //1
        //0
        //2
        int mid = low + (high - low) / 2;
        //0,1
        //0,0 return
        //2,2 return
        sort(a, low, mid);
        //2,3
        //1,1 return
        //3,3 return
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
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
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }


}
