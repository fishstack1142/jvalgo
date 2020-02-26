package queue;

import java.util.Arrays;

public class ArrayQueue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        int front = queue.dequeue();
        System.out.println(front);
        queue.dequeue();
        System.out.println(queue.toString());
    }

    private int[] items;
    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length; //implement circular array
        count++;
    }

    public int dequeue() {
        int item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length; //implement circular array
        count--;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
