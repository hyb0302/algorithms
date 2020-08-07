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
            // a2 < b1 || b2 < a1
            if (a2 >= b1 && b2 >= a1) {
                r.add(Arrays.asList(Math.max(a1, b1), Math.min(a2, b2)));
            }

            if (a2 < b2) {
                i++;
            } else {
                j++;
            }

        }

        return r;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] b = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        List<List<Integer>> cal = cal(a, b);
        for (List<Integer> list : cal) {
            System.out.println(list.toString());
        }

    }

}
