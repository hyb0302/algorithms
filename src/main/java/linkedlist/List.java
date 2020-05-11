package linkedlist;

/**
 * @author huangyb
 * @date 2020/4/12
 */
public interface List<T> {

    T get(int index);

    void add(T data);

    void add(T data, int index);

    int size();

    void addAll(List<T> list);

    void reverse();

}
