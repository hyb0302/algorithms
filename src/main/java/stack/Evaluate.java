package stack;

/**
 * @author huangyb
 * @date 2020/5/10
 */
public class Evaluate {

    public static double calculate(String expression) {
        Stack<String> ops = new LinkedListStack<>();
        Stack<Double> vals = new LinkedListStack<>();

        for (char c : expression.toCharArray()) {
            String s = String.valueOf(c);
            if ("(".equals(s)) {

            } else if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                ops.push(s);
            } else if (")".equals(s)) {
                String op = ops.pop();
                double d2 = vals.pop();
                double d1 = vals.pop();
                if ("+".equals(op)) {
                    vals.push(d1 + d2);
                } else if ("-".equals(op)) {
                    vals.push(d1 - d2);
                } else if ("*".equals(op)) {
                    vals.push(d1 * d2);
                } else if ("/".equals(op)) {
                    vals.push(d1 / d2);
                }
            } else {
                vals.push(Double.parseDouble(s));
            }
        }

        return vals.pop();
    }
    public static void main(String[] args) {
        System.out.println(Evaluate.calculate("(1+((2+3)*(4*5)))"));

    }
}
