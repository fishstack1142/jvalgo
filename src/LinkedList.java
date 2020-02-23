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

    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int item) {
        Node node = new Node(item);

        if(isEmpty()){
            first = last = node;
        }
        else{
            node.next = first;
            first = node;
        }
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
        }

        Node second = first.next;
        first.next = null;
        first = second;
    }

    public void removeLast() {
        try {
            if (isEmpty())
                throw new NoSuchFieldException();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //if there is only one node
        if (first == last){
            first = last = null;
        }

        Node previous = getPrevious(last);
        last = previous;
        last.next = null;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) return current;

            current = current.next;

        }
        return null;
    }


    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addFirst(30);
        list.removeLast();

//        System.out.println(list.indexOf(20));
//        System.out.println(list.contains(40));
//        System.out.println(list.first);
    }
}
