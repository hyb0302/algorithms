package sorting;


/**
 * @author huangyb
 * @date 2020/6/7
 */
public class Main {

    public static void main(String[] args) {
        long shell = SortCompare.timeRandomInput(Shell.INSTANCE, 10000, 5);
        long insertion = SortCompare.timeRandomInput(Insertion.INSTANCE, 10000, 5);


        System.out.println("shell:" + shell + "," + shell / 5.0);
        System.out.println("insertion:" + insertion + "," + insertion / 5.0);

    }
}
