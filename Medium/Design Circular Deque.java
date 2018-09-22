class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    Queue<Integer> main;
    Queue<Integer> backup;
    int capacity;
    
    public MyCircularDeque(int k) {
        main = new LinkedList<>();
        backup = new LinkedList<>();
        capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (main.size() == capacity) {
            return false;
        }
        
        while(!main.isEmpty()) {
            backup.add(main.remove());
        }
        
        main.add(value);
        
        while (!backup.isEmpty()) {
            main.add(backup.remove());
        }
        
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (main.size() == capacity) {
            return false;
        }
        
        main.add(value);
        
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (main.isEmpty()) {
            return false;
        }
        
        main.remove();
        
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (main.isEmpty()) {
            return false;
        }
        
        while(!main.isEmpty()) {
            backup.add(main.remove());
        }
        
        int size = backup.size();
        
        while (size-- > 1) {
            main.add(backup.remove());
        }
        
        backup.remove();
        
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (main.isEmpty()) {
            return -1;
        }
        
        return main.peek();
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (main.isEmpty()) {
            return -1;
        }
        
        while(!main.isEmpty()) {
            backup.add(main.remove());
        }
        
        int size = backup.size();
        
        while (size-- > 1) {
            main.add(backup.remove());
        }
        
        int ans = backup.peek();
        main.add(backup.remove());
        
        return ans;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return main.isEmpty();
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return main.size() == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
