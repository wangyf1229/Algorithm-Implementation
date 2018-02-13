class MinStack {
    int minValue;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.minStack = new Stack<>();
        this.minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= minValue) {
            minStack.push(minValue);
            minStack.push(x);
            minValue = x;
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = minStack.pop();
        if (x == minValue) {
            minValue = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */