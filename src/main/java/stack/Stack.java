package stack;

/**
 * @author huangyb
 * @date 2020/4/12
 */
public interface Stack<T> extends Iterable<T> {

    boolean push(T data);

    T pop();

    int size();

    boolean isEmpty();
}
