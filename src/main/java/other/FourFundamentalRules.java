package other;

/**
 * @author huangyb
 * @date 2020/7/26
 */
public class FourFundamentalRules {


    public static int add(int i, int j) {
        int result;
        while (true) {
            result = i ^ j;
            int i1 = i & j;
            if (i1 == 0) {
                break;
            }
            i = result;
            j = i1 << 1;
        }
        return result;
    }

    public static int sub(int i, int j) {
        return add(i, ~j + 1);
    }

    public static void main(String[] args) {
        System.out.println(FourFundamentalRules.add(3, 7));
        System.out.println(FourFundamentalRules.sub(3, 7));

//        System.out.println(3 ^ 7);
    }

}
