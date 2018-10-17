class MyCircularQueue {

    int[] array;
    int head;
    int tail;
    int size;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.array = new int[k];
        this.head = 0; //point to the first element (should be set 0 in case call enQueue once and then call Front())
        this.tail = -1; //should point to the last element
        this.size = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == array.length) return false;
        if (tail == (array.length - 1)) tail = -1;
        tail++;
        array[tail]=value;
        size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0) return false;
        head++;
        if (head == array.length) head = 0;
        size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) return -1;
        return array[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) return -1;
        return array[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == array.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */