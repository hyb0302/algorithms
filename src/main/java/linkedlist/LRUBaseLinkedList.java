package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author huangyb
 * @date 2020/4/15
 */
public class LRUBaseLinkedList<T> {

    private Integer capacity;

    private LinkedList.Node<T> head;

    private int length;

    public LRUBaseLinkedList(Integer capacity) {
        head = new LinkedList.Node<T>(null);
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        if (capacity == 0) {
            return;
        }
        LinkedList.Node<T> previous = head;
        LinkedList.Node<T> n = previous.getNext();
        while (n != null) {
            if (n.getData().equals(data)) {
                break;
            }
            previous = n;
            n = n.getNext();
        }

        //没在链表中找到相同的数据，新增到链表头
        if (n == null) {
            //剔除链表尾的数据
            if (length >= capacity) {
                removeTail();
                --length;
            }
            insertNodeAtBegin(new LinkedList.Node<T>(data));
            ++length;
            return;
        }
        //找到相同数据，把该节点移到链表头
        previous.setNext(n.getNext());
        insertNodeAtBegin(n);
    }

    private void insertNodeAtBegin(LinkedList.Node<T> node) {
        LinkedList.Node<T> oldHead = head.getNext();
        node.setNext(oldHead);
        head.setNext(node);
    }

    private void removeTail() {
        LinkedList.Node<T> n = head.getNext();
        LinkedList.Node<T> previous = head;

        while (n.getNext() != null) {
            previous = n;
            n = n.getNext();
        }
        previous.setNext(null);
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        LinkedList.Node<T> n = head.getNext();
        while (n != null) {
            s.append(n.getData().toString()).append(",");
            n = n.getNext();
        }
        String s1 = s.toString();
        if (s1.endsWith(",")) {
            return "[" + s1.substring(0, s1.length() - 1) + "]";
        }
        return "[" + s1 + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        LRUBaseLinkedList<String> l = new LRUBaseLinkedList<String>(5);
        while (true) {
            String s = b.readLine();
            if ("exit".equals(s)) {
                break;
            }
            l.add(s);
            System.out.println(l.toString());
        }

    }
}
