import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Array numbers = new Array(3);
        numbers.insert(2);
        numbers.insert(4);
        numbers.insert(45);
        numbers.insert(45);
        numbers.insert(45);
        System.out.println(numbers.indexOf(4));

//        numbers.removeAt(1);
        numbers.print();
    }
}

class Array {
    private int[] items;
    private int count;

    public Array(int length) {

        items = new int[length];
    }

    public void insert(int item) {

        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }

            items = newItems;
        }

        items[count++] = item;
//        System.out.println("count is " + count);
    }

    public void removeAt(int index) {

        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }

        count--;
    }

    int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;

    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }
}
