package stringmatching;

/**
 * @author huangyb
 * @date 2020/12/6
 */
public class BF implements StringMatching {

    @Override
    public boolean contains(String main, String pattern) {
        char[] mainChars = main.toCharArray();
        char[] patternChars = pattern.toCharArray();
        if (mainChars.length < patternChars.length) {
            return false;
        }
        boolean f = false;
        for (int i = 0; i < mainChars.length - patternChars.length + 1; i++) {
            for (int j = 0; j < patternChars.length; j++) {

            }
        }


        return false;
    }

    private boolean eq(char[] c1, char[] c2) {
        if (c1.length != c2.length) {
            return false;
        }
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }


}
