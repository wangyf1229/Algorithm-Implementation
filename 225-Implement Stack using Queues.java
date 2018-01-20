public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> emptyQueue = queue1.peek() == null ? queue1 : queue2;
        Queue<Integer> fullQueue = queue1.peek() == null ? queue2 : queue1;
        emptyQueue.offer(x);
        while (fullQueue.size() != 0) {
            emptyQueue.offer(fullQueue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> fullQueue = queue1.peek() == null ? queue2 : queue1;
        return fullQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        Queue<Integer> fullQueue = queue1.peek() == null ? queue2 : queue1;
        return fullQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.peek() == null && queue2.peek() == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

//Better Solution => One queue;
public class MyStack {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
       queue.offer(x);
       int sz = queue.size();
       for (int i = 0; i < sz - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.peek() == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */