package stringmatching;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangyb
 * @date 2021/1/2
 */
public class Trie {

    private TrieDataNode root = new TrieDataNode('/');

    public void insert(String s) {
        insert(s.toCharArray());
    }

    public void insert(char[] chars) {
        TrieDataNode p = this.root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieDataNode trieDataNode = new TrieDataNode(c);
                p.children[index] = trieDataNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(String s) {
        return find(s.toCharArray());
    }


    public boolean find(char[] pattern) {
        TrieDataNode p = this.root;
        for (int i = 0; i < pattern.length; i++) {
            char c = pattern[i];
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }

        return p.isEndingChar;
    }

    public String[] search(String s) {
        return search(s.toCharArray());
    }

    public String[] search(char[] pattern) {
        TrieDataNode p = this.root;
        for (int i = 0; i < pattern.length; i++) {
            char c = pattern[i];
            int index = c - 'a';
            if (p.children[index] == null) {
                return new String[0];
            }
            p = p.children[index];
        }
        List<String> result = new ArrayList<>();
        search(p, result, new String(pattern));
        return result.toArray(new String[0]);
    }

    private void search(TrieDataNode node, List<String> result, String prefix) {
        if (node.isEndingChar) {
            result.add(prefix);
        }
        for (int i = 0; i < node.children.length; i++) {
            TrieDataNode c = node.children[i];
            if (c == null) {
                continue;
            }
            search(c, result, prefix + c.data);
        }
    }




    public static class TrieDataNode {

        private char data;

        private TrieDataNode[] children = new TrieDataNode[26];

        private boolean isEndingChar;

        public TrieDataNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("her");
        trie.insert("his");
        trie.insert("hi");
        trie.insert("how");
        trie.insert("human");
        trie.insert("so");
        trie.insert("see");
        System.out.println(trie.find("his"));
        System.out.println(trie.find("hi"));
        System.out.println(trie.find("he"));
        System.out.println(trie.find("her"));
        System.out.println(Arrays.toString(trie.search("h")));
    }
}
