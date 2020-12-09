package stringmatching;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huangyb
 * @date 2020/12/8
 */
public class Test {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static void t1(StringMatching s) {
        assert s.contains("s", "s");
        assert !s.contains("a", "s");
        assert !s.contains("sss", "sa");
        assert s.contains("sss", "sss");
        assert s.contains("sss", "s");
        assert s.contains("aseba", "seba");
        assert s.contains("aseba", "");
        assert s.contains("hello", "ll");
        assert !s.contains("hello", "ab");
        assert s.contains("aaba", "ab");
        assert !s.contains("asba", "ab");
    }

    public static void test(StringMatching s) {
        t1(s);
//        System.out.println("ok");
    }

    public static void randomTest(StringMatching s) {
        s.contains(randomString(10), randomString(8));
    }

    private static String randomString(int minLength, int maxLength) {
        return randomString(minLength + RANDOM.nextInt(maxLength - minLength));
    }

    private static String randomString(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = (char) (97 + RANDOM.nextInt(26));
        }
        return new String(chars);
    }

    private static void testInTheSameData(int times) {
        List<List<String>> l = new ArrayList<>(times);
        for (int i = 0; i < times; i++) {
            l.add(Arrays.asList(randomString(10), randomString(3, 6)));
        }
        RK rk = new RK();
        BF bf = new BF();
        randomTest(bf);
        randomTest(rk);



        LocalDateTime start1 = LocalDateTime.now();
        for (int i = 0; i < times; i++) {
            bf.contains(l.get(i).get(0), l.get(i).get(1));
        }
        System.out.println("bf: " + Duration.between(start1, LocalDateTime.now()).getNano());

        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < times; i++) {
            rk.contains(l.get(i).get(0), l.get(i).get(1));
        }
        System.out.println("rk: " + Duration.between(start, LocalDateTime.now()).getNano());

    }

    public static void main(String[] args) {
//        int times = 10000;
//        RK rk = new RK();
//        BF bf = new BF();
//        randomTest(bf);
//        randomTest(rk);
//
//        LocalDateTime start = LocalDateTime.now();
//        for (int i = 0; i < times; i++) {
//            randomTest(rk);
//        }
//        System.out.println("rk: " + Duration.between(start, LocalDateTime.now()).getNano());
//
//        LocalDateTime start1 = LocalDateTime.now();
//        for (int i = 0; i < times; i++) {
//            randomTest(bf);
//        }
//        System.out.println("bf: " + Duration.between(start1, LocalDateTime.now()).getNano());

        testInTheSameData(10000);
    }

}
