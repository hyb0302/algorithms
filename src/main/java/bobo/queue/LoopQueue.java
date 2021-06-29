package bobo.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front;

    private int tail;

    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    private int dataIndexFor(int index) {
        return index % data.length;
    }

    @Override
    public void enqueue(E e) {
        if (dataIndexFor(tail + 1) == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = dataIndexFor(tail + 1);
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[dataIndexFor(front + i)];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        final E ret = data[front];
        data[front] = null;
        front = dataIndexFor(front + 1);
        size--;
        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d \n", size, getCapacity()));
        res.append("front [");
//        for (int i = 0; i < size; i++) {
//            res.append(data[dataIndexFor(i + front)]);
//            if (i != size - 1) {
//                res.append(", ");
//            }
//        }
        for (int i = front; i != tail; i = dataIndexFor(i + 1)) {
            res.append(data[i]);
            if (dataIndexFor(i + 1) != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 1) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
