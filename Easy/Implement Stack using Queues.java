class MyStack {
    
    private final Queue<Integer> mainQueue;
    private final Queue<Integer> backupQueue;

    public MyStack() {
        this.mainQueue = new LinkedList<>();
        this.backupQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        this.mainQueue.add(x);
    }
    
    public int pop() {
        int lastElement = moveToBackupQueue();
        moveToMainQueue(true);
        return lastElement;
    }
    
    public int top() {
        int lastElement = moveToBackupQueue();
        moveToMainQueue(false);
        return lastElement;
    }
    
    public boolean empty() {
        return this.mainQueue.isEmpty();
    }
    
    private int moveToBackupQueue() {
        int lastElement = this.mainQueue.peek();
        while (!this.mainQueue.isEmpty()) {
            lastElement = this.mainQueue.peek();
            this.backupQueue.add(this.mainQueue.poll());
        }
        return lastElement;
    }
    
    private void moveToMainQueue(boolean removeLast) {
        int sizeLimit = removeLast ? 1 : 0;
        while (this.backupQueue.size() > sizeLimit) {
            this.mainQueue.add(this.backupQueue.poll());
        }
        if (removeLast) {
            this.backupQueue.remove();
        }
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
