package sorting;

import java.util.Arrays;

/**
 * @author huangyb
 * @date 2020/6/4
 */
public class Selection extends AbstractSort{

    public static final Selection INSTANCE = new Selection();

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

}
