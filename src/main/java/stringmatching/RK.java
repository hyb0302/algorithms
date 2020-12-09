package stringmatching;

/**
 * @author huangyb
 * @date 2020/12/6
 * Rabin-Karp
 */
public class RK implements StringMatching {

    @Override
    public boolean contains(String main, String pattern) {
        char[] mainChars = main.toCharArray();
        char[] patternChars = pattern.toCharArray();
        if (mainChars.length < patternChars.length) {
            return false;
        }
        int[] mainHash = new int[mainChars.length - patternChars.length + 1];
        //计算主串的哈希值
        for (int i = 0; i < mainChars.length - patternChars.length + 1; i++) {
            int hash = 0;
            for (int j = 0; j < patternChars.length; j++) {
                hash += getNum(mainChars[i + j]);
            }
            mainHash[i] = hash;
        }
        int patternHash =  0;
        for (int i = 0; i < patternChars.length; i++) {
            patternHash += getNum(patternChars[i]);
        }

        for (int i = 0; i < mainHash.length; i++) {
            if (mainHash[i] == patternHash) {
                boolean f = true;
                for (int j = 0; j < patternChars.length; j++) {
                    if (mainChars[i + j] != patternChars[j]) {
                        f = false;
                    }
                }
                if (f) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getNum(char c) {
        return c;
    }

    public static void main(String[] args) {
        Test.test(new RK());
    }
}
