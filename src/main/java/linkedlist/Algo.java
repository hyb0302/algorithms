package linkedlist;

import com.sun.istack.internal.NotNull;

/**
 * @author huangyb
 * @date 2020/4/17
 */
public class Algo {

    /**
     * 两个有序的链表合并
     * @param l1
     * @param l2
     * @param descending
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> LinkedList<T> sortedMerge(@NotNull LinkedList<T> l1, @NotNull LinkedList<T> l2, boolean descending) {
        LinkedList<T> result = new LinkedList<T>();

        LinkedList.Node<T> h1 = l1.getHead();
        LinkedList.Node<T> h2 = l2.getHead();

        while (h1 != null && h2 != null) {
            int r = descending ? h1.getData().compareTo(h2.getData()) * -1 : h1.getData().compareTo(h2.getData());
            if (r < 0) {
                result.add(h1.getData());
                h1 = h1.getNext();
            } else if (r > 0) {
                result.add(h2.getData());
                h2 = h2.getNext();
            } else {
                result.add(h1.getData());
                h1 = h1.getNext();
            }
        }
        LinkedList.Node<T> t;
        if (h1 != null) {
            t = h1;
        } else if (h2 != null) {
            t = h2;
        } else {
            return result;
        }

        while (t != null) {
            result.add(t.getData());
            t = t.getNext();
        }
        return result;
    }

    /**
     * 单链表反转
     * @param list
     * @param <T>
     */          // 1 2 3 4 5
    public static <T> void reverse(LinkedList<T> list) {
        if (list.getHead() == null || list.getHead().getNext() == null) {
            return;
        }
        LinkedList.Node<T> previous = null;
        LinkedList.Node<T> current = list.getHead();
        LinkedList.Node<T> next = list.getHead().getNext();
        while (next != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            next = next.getNext();
        }
        current.setNext(previous);
        list.setHead(current);
    }

    /**
     * 删除链表倒数第 n 个结点
     * @param list
     * @param n
     * @param <T>
     * @return
     */                      //1 2 3 4 5
    public static <T> T removeNFromLast(LinkedList<T> list, int n) {
        if (n < 0) {
            return null;
        }
        LinkedList.Node<T> fast = list.getHead();
        LinkedList.Node<T> slow = list.getHead();

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.getNext();
        }
        if (fast == null) {
            LinkedList.Node<T> head = list.getHead();
            list.setHead(head.getNext());
            return head.getData();
        }

        LinkedList.Node<T> previous = null;
        while (fast != null) {
            fast = fast.getNext();
            previous = slow;
            slow = slow.getNext();
        }

        previous.setNext(slow.getNext());
        return slow.getData();
    }

    /**
     * 求链表的中间结点
     * @param list
     * @param <T>
     * @return
     */        // 1 2 3 4 5 6 7
    public static <T> T middleNode(LinkedList<T> list) {

        LinkedList.Node<T> fast = list.getHead();
        LinkedList.Node<T> slow = list.getHead();

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow.getData();
    }

    /**
     * 链表中环的检测
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Boolean hasCycle(LinkedList<T> list) {
        LinkedList.Node<T> fast = list.getHead();
        LinkedList.Node<T> slow = list.getHead();

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int result = 0;
        int pre = 2;
        int prepre = 1;

        for (int i = 3; i <= n; i++) {
            result = pre + prepre;
            prepre = pre;
            pre = result;
        }

        return result;
    }



    public static void main(String[] args) {
        f(5);

//        LinkedList<Integer> l1 = new LinkedList<Integer>();
//        l1.add(2);
//        l1.add(5);
//        l1.add(7);
//        l1.add(8);
//        l1.add(9);
//        LinkedList<Integer> l2 = new LinkedList<Integer>();
//        l2.add(1);
//        l2.add(2);
//        l2.add(8);
//
//        System.out.println(sortedMerge(l1, l2, false).toString());
//
//        Integer integer = removeNFromLast(l1, 1);
//        System.out.println(integer);
//        System.out.println(l1);
//
//        LinkedList<Integer> l = new LinkedList<>();
//        l.add(1);
//        l.add(2);
//        l.add(3);
//        l.add(4);
//        l.add(5);
//        l.add(6);
//        System.out.println(middleNode(l));
//
//
//        LinkedList<Integer> cycle = new LinkedList<>();
//
//        LinkedList.Node<Integer> head = new LinkedList.Node<>(1);
//        LinkedList.Node<Integer> n = new LinkedList.Node<>(3);
//        LinkedList.Node<Integer> n1 = new LinkedList.Node<>(4);
//        LinkedList.Node<Integer> n2 = new LinkedList.Node<>(5);
//        head.setNext(new LinkedList.Node<>(2));
//        head.getNext().setNext(n);
//        n.setNext(n1);
//        n1.setNext(n2);
//        n2.setNext(n);
//        cycle.setHead(head);
//        System.out.println(hasCycle(cycle));
//
//        reverse(l);
//        System.out.println(l.toString());


    }
}
