package sorting;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author huangyb
 * @date 2020/6/8
 */
public class SortCompare {

    public static long time(AbstractSort s, Comparable[] a) {
        LocalDateTime start = LocalDateTime.now();
        s.sort(a);
        LocalDateTime end = LocalDateTime.now();
        return Duration.between(start, end).toMillis();
    }

    public static long timeRandomInput(AbstractSort s, int size, int times) {
        long total = 0L;
        for (int i = 0; i < times; i++) {
            total += time(s, RandomArray.generate(size));
        }
        return total;
    }
}
