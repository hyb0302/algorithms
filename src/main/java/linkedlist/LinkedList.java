package linkedlist;


/**
 * @author huangyb
 * @date 2020/4/12
 */
public class LinkedList<T> implements List<T> {

    private Node<T> head;

    public LinkedList() {
    }


    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    private Node<T> getTail() {
        if (head == null) {
            return null;
        }
        Node<T> n = head;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        return n;
    }

    @Override
    public T get(int index) {
        int count = 0;
        Node<T> n = head;
        while (index > count) {
            if (n == null) {
                return null;
            }
            n = n.getNext();
            count++;
        }
        return n.getData();
    }


    @Override
    public void add(T data) {
        Node<T> tail = getTail();
        if (tail == null) {
            head = new Node<T>(data);
        } else {
            tail.setNext(new Node<T>(data));
        }
    }

    @Override
    public void add(T data, int index) {
        if (index > size() || index < 0) {
            return;
        } else if (index == size()) {
            add(data);
            return;
        }
        if (index == 0) {
            if (head == null) {
                head = new Node<T>(data);
            } else {
                Node<T> n = new Node<T>(data);
                n.setNext(head);
                head = n;
            }
            return;
        }

        Node<T> previous = head;
        Node<T> n = head;
        int count = 0;
        while (index > count) {
            previous = n;
            n = n.getNext();
            count++;
        }
        previous.setNext(new Node<T>(data));
        previous.getNext().setNext(n);

    }

    @Override
    public int size() {
        int size = 0;
        Node<T> n = head;
        while (n != null) {
            n = n.getNext();
            size++;
        }
        return size;
    }

    @Override
    public void addAll(List<T> list) {
        if (list == null) {
            return;
        }
        Node<T> last = getTail();
        if (last == null) {

        } else {

        }
    }

    @Override
    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }
        Node<T> c = head;
        Node<T> next = head.getNext();
        Node<T> previous = null;
        // 1 2 3 4 5
        while (next != null) {
            c.setNext(previous);
            previous = c;
            c = next;
            next = c.getNext();
        }
        c.setNext(previous);
        head = c;
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node<T> n = head;
        StringBuilder s = new StringBuilder();
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
}
