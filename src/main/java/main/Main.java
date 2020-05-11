package main;

import linkedlist.LinkedList;

/**
 * @author huangyb
 * @date 2020/4/6
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
//        l.add("7", 0);
        l.reverse();
        System.out.println(l.toString());

        String s = "ss";
        s = "2";
    }
}
