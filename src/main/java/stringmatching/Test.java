package stringmatching;


/**
 * @author huangyb
 * @date 2020/12/8
 */
public class Test {

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
    }

    public static void test(StringMatching s) {
        t1(s);
        System.out.println("ok");
    }


}
