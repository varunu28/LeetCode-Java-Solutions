class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    Node head;
    Node curr;
    int capacity;
    int count = 0;

    public MyCircularQueue(int k) {
        head = new Node(-1);
        curr = head;
        capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (count == capacity) {
            return false;
        }

        curr.next = new Node(value);
        curr = curr.next;
        count++;

        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (count <= 0) {
            return false;
        }

        if (head.next == curr) {
            curr = head;
            head.next = null;
        }
        else {
            head.next = head.next.next;
        }

        count--;

        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (count == 0) {
            return -1;
        }

        return head.next.value;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (count == 0) {
            return -1;
        }

        return curr.value;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == capacity;
    }

    private void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
        }

        System.out.println();
    }

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
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
