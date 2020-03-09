package heap;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
//        heap.insert(4);
//        heap.insert(22);

        System.out.println(Arrays.toString(heap.items));
    }


    public int[] items = new int[10];
    private int size;

     public void insert(int value) {
         if (isFull())
             throw new IllegalStateException();

         items[size++] = value;

         bubbleUp();
     }

     public boolean isFull() {
         return size == items.length;
     }

     private void bubbleUp() {
         //if newItem > parent
         int index = size - 1;
         while (index > 0 && items[index] > items[parent(index)]) {
             swap(index, parent(index));
             index = parent(index);
         }
     }

     private int parent(int index) {
         return (index - 1) / 2;
     }

     private void swap(int first, int second) {
         int temp = items[first];
         items[first] = items[second];
         items[second] = temp;
     }
}
