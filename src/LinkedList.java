import java.util.Arrays;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {

        return indexOf(item) != -1;
    }

    public void removeFirst() {
        try {
            if (isEmpty())
                throw new NoSuchFieldException();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        if (first == last) {
            first = last = null;
            return;
        } else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        try {
            if (isEmpty())
                throw new NoSuchFieldException();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //if there is only one node
        if (first == last) {
            first = last = null;
        } else {
            Node previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) return current;

            current = current.next;

        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {

        if (isEmpty()) return;

        Node previous = first;
        Node current = first.next;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

//    public int getKthFromTheEnd(int k) {
// TODO
//
//    }


    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addFirst(40);
        list.addFirst(30);
        list.addLast(50);
//        list.removeLast();
//        System.out.println(list.size);
        list.reverse();

        System.out.println(Arrays.toString(list.toArray()));
//        System.out.println(list.indexOf(20));
//        System.out.println(list.contains(40));
//        System.out.println(list.first);
    }
}
