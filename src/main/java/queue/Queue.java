package queue;

/**
 * @author huangyb
 * @date 2020/5/10
 */
public interface Queue<T> extends Iterable<T> {

    boolean enqueue(T item);

    T dequeue();

    int size();

    boolean isEmpty();
}
