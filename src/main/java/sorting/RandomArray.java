package sorting;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author huangyb
 * @date 2020/6/7
 */
public class RandomArray {

    public static Integer[] generate(int size) {
        Set<Integer> set = new LinkedHashSet<>(size);
        Random random = new Random();
        while (set.size() != size) {
            set.add(random.nextInt(size * 4));
        }
        return set.toArray(new Integer[size]);
    }

}
