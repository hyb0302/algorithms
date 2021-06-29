package bobo.array;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 200);
        System.out.println(array);
//        array.addFirst(-1);
        array.remove(1);
        System.out.println(array);

    }
}
