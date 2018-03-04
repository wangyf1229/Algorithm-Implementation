public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        //Solution 1 => Needs more space;
        // if (minStack.empty()) {
        //     minStack.push(number);
        // } else {
        //     minStack.push(number < minStack.peek() ? number : minStack.peek());
        // }

        //Solution 2 => Less Space
        if (minStack.empty()) {
            minStack.push(number);
        } else {
            if (number <= minStack.peek()) {
                minStack.push(number);
            }
        }
    }

    public int pop() {
        //Solution 2
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
