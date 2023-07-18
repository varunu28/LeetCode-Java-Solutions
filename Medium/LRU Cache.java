class LRUCache {
    
    private final Map<Integer, Node> map;
    private final int capacity;
    private final Node head;
    private final Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            updateExistingKey(key, value);
            return;
        }
        if (map.size() == this.capacity) {
            Node leastUsed = tail.prev;
            removeNode(leastUsed);
            map.remove(leastUsed.key);
        }
        Node newNode = new Node(key, value);
        addToFront(newNode);
        map.put(key, newNode);
    }

    private void updateExistingKey(int key, int value) {
        Node node = map.get(key);
        Node updatedNode = new Node(key, value);
        removeNode(node);
        addToFront(updatedNode);
        map.put(key, updatedNode);
    }

    private void removeNode(Node node) {
        Node prevToNode = node.prev;
        Node nextToNode = node.next;
        prevToNode.next = nextToNode;
        nextToNode.prev = prevToNode;
    }

    private void addToFront(Node node) {
        Node nextToHead = head.next;
        node.next = nextToHead;
        nextToHead.prev = node;
        node.prev = head;
        head.next = node;
    }

    private static class Node {

        private final int key;
        private final int value;
        private Node next;
        private Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
