package bobo.stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(isValid("(([{}]))"));
        System.out.println(isValid("(([{]))"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                final Character top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
