import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackThread {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);

        int top = stack.pop();
        System.out.println(top);
        System.out.println(stack);
        top = stack.peek();
        System.out.println(top);

    }
}


class StringReverser {

    public static void main(String[] args) {

        String str = "thoutdemo";

        StringReverser reverser = new StringReverser();
        String result = reverser.reverse(str);

        System.out.println(result);
    }

    public String reverse(String input) {

        if (input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray())
            stack.push(ch);

        StringBuffer reversed = new StringBuffer();
        while (!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();
    }
}

class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public static void main(String[] args) {

        String str = "(1 + 2)";
//        String str = ")1 + 2(";
        Expression exp = new Expression();
        Boolean result = exp.isBalanced(str);
        System.out.println(result);


    }

    public boolean isBalanced(String input) {

        Stack<Character> stack = new Stack<>();

        System.out.println(input.toCharArray());

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch)) stack.push(ch);

            if (isRightbracket(ch)) {
                if (stack.empty()) return false;

                char top = stack.pop();
                if (bracketsMatch(top, ch)) return false;
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightbracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {

        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);

//        return (right == ')' && left != '(' ) ||
//               (right == '>' && left != '<' ) ||
//               (right == ']' && left != '[' ) ||
//               (right == '}' && left != '{' );
    }

}

class MyStack {

    private int[] items = new int[5];
    private int count;

    public void push(int item) {
        if (count == items.length)
            throw new StackOverflowError();

        items[count++] = item;
    }

    public int pop() {
        if (count == 0)
            throw new IllegalStateException();

        return items[--count];
    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();

        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items, 0, count));
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(19);
        stack.push(20);
        stack.push(21);
        stack.pop();
        System.out.println(stack.toString());
    }
}