package sorting;

/**
 * @author huangyb
 * @date 2020/7/27
 */
public class Heap extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        //长度除以2就是下标最大的父节点（最后一个非叶子节点），每个父节点都做下沉操作，但 for 循环之后只是构造了堆（堆有序），并不是有序状态
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exchange(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private void sink(Comparable[] a, int i, int size) {
        while (2 * i <= size) {
            int j = 2 * i;
            if (j > size && less(a[j], a[j + 1])) {
                j++;
            }
            if (less(a[j], a[i])) {
                break;
            }
            exchange(a, i, j);
            i = j;
        }
    }
}
