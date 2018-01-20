public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> emptyStack = stack1.empty() ? stack1 : stack2;
        Stack<Integer> fullStack = stack1.empty() ? stack2 : stack1;
        while (!fullStack.empty()) {
            emptyStack.push(fullStack.pop());
        }
        fullStack.push(x);
        while (!emptyStack.empty()) {
            fullStack.push(emptyStack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> fullStack = stack1.empty() ? stack2 : stack1;
        return fullStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        Stack<Integer> fullStack = stack1.empty() ? stack2 : stack1;
        return fullStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */