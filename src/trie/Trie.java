package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
//        System.out.println(trie.contains("can"));
        trie.remove("egg");
//        trie.traverse();

        List<String> words = trie.findWords("c");
        System.out.println(words);
    }

    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
//        private Node[] children = new Node[ALPHABET_SIZE];
        private HashMap<Character, Node> children =  new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value= " + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
              current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        Node current = root;
        for (char ch : word.toCharArray()) {
            if(!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        //Pre-order visit the root first
        System.out.println(root.value);

        for (Node child : root.getChildren())
            traverse(child);
    }

    public void remove(String word) {
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
//            System.out.println(root.value);
            root.isEndOfWord = false;
            return;
        }

        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);
//        System.out.println(root.value);

        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastNode = findLastNodeOf(prefix);

        findWords(lastNode, prefix, words);

        return words;
    }

    private void findWords(Node root, String prefix, List<String> words){

        if(root == null)
            return;

        if (root.isEndOfWord)
            words.add(prefix);

        for (Node child : root.getChildren())
            findWords(child, prefix + child.value, words);
    }

    private Node findLastNodeOf(String prefix) {

        if (prefix == null)
            return null;

        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;

        }
        return current;
    }
}
