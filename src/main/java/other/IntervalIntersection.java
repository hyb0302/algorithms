package other;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangyb
 * @date 2020/6/17
 */
public class IntervalIntersection {

    public static List<List<Integer>> cal(int[][] a, int[][] b) {
        List<List<Integer>> r = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            int a1 = a[i][0];
            int a2 = a[i][1];
            int b1 = b[j][0];
            int b2 = b[j][1];

            if (a1 > b2 || b1 > a2) {

            }
            if (a1 <= b2 && b1 <= a2) {

            }

            r.add(Arrays.asList(Math.max(a1, b1), Math.min(a2, b2)));

            if (a2 < b2) {
                i++;
            } else if (b2 < a2) {
                j++;
            } else {
                i++;
                j++;
            }

        }

        return r;
    }


}
