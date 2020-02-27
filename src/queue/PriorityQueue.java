package queue;

import java.util.Arrays;

public class PriorityQueue {

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue();
        queue.add(4);
        queue.add(1);
        queue.add(8);
        queue.add(3);
        queue.add(2);
        System.out.println(queue);

        while (!queue.isEmpty())
            System.out.println(queue.remove());
    }

    private int[] items = new int[5];
    private int count;

    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();

        //shifting items from last
//        int i;
//        for (i = count - 1; i >= 0; i--) {
//            if (items[i] > item)
//                items[i + 1] = items[i];
//            else
//                break;
//        }

        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public int shiftItemsToInsert(int item) {
        //shifting items from last
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    private boolean isEmpty() {
        return count == 0;
    }


    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
