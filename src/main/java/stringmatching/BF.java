package stringmatching;

/**
 * @author huangyb
 * @date 2020/12/6
 * brute force 暴力匹配
 */
public class BF implements StringMatching {

    @Override
    public boolean contains(String main, String pattern) {
        char[] mainChars = main.toCharArray();
        char[] patternChars = pattern.toCharArray();
        if (mainChars.length < patternChars.length) {
            return false;
        }

        for (int i = 0; i < mainChars.length - patternChars.length + 1; i++) {
            boolean f = true;
            for (int j = 0; j < patternChars.length; j++) {
                if (mainChars[i + j] != patternChars[j]) {
                    f = false;
                    break;
                }
            }
            if (f) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test.test(new BF());

    }
}
