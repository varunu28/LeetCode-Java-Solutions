class LFUCache {

    private final TreeMap<Integer, NodeLinkedList> frequencyToNodeMap;
    private final Map<Integer, Node> keyToNodeMap;
    private final int capacity;

    public LFUCache(int capacity) {
        this.frequencyToNodeMap = new TreeMap<>();
        this.keyToNodeMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyToNodeMap.get(key);
        updateNodeForFrequencyChange(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (this.keyToNodeMap.containsKey(key)) {
            updateNode(key, value);
        } else {
            addNewNode(key, value);
        }
    }

    private void updateNode(int key, int value) {
        Node node = keyToNodeMap.get(key);
        node.value = value;
        updateNodeForFrequencyChange(node);
    }

    private void addNewNode(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (capacity == keyToNodeMap.size()) {
            evictCache();
        }
        Node node = new Node(key, value);
        addToFrequencyMap(node);
        keyToNodeMap.put(key, node);
    }

    private void evictCache() {
        int firstKey = frequencyToNodeMap.firstKey();
        Node nodeToEvict = frequencyToNodeMap.get(firstKey).getFirstNode();
        removeNode(nodeToEvict);
        keyToNodeMap.remove(nodeToEvict.key);
        if (frequencyToNodeMap.get(firstKey).getFirstNode().value == -1) {
            frequencyToNodeMap.remove(firstKey);
        }
    }

    private void updateNodeForFrequencyChange(Node node) {
        int prevFrequency = node.frequency;
        node.frequency = node.frequency + 1;
        removeNode(node);
        if (frequencyToNodeMap.get(prevFrequency).getFirstNode().value == -1) {
            frequencyToNodeMap.remove(prevFrequency);
        }
        addToFrequencyMap(node);
    }

    private void removeNode(Node node) {
        Node prevToNode = node.prev;
        Node nextToNode = node.next;
        prevToNode.next = nextToNode;
        nextToNode.prev = prevToNode;
    }

    private void addToFrequencyMap(Node node) {
        if (!frequencyToNodeMap.containsKey(node.frequency)) {
            frequencyToNodeMap.put(node.frequency, new NodeLinkedList());
        }
        frequencyToNodeMap.get(node.frequency).addNode(node);
    }

    private static class NodeLinkedList {
        private final Node head;
        private final Node tail;

        public NodeLinkedList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public Node getFirstNode() {
            return head.next;
        }

        public void addNode(Node node) {
            Node prevToTail = tail.prev;
            node.prev = prevToTail;
            prevToTail.next = node;
            node.next = tail;
            tail.prev = node;
        }
    }

    private static class Node {
        private final int key;
        private int value;
        private int frequency;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
            this.next = null;
            this.prev = null;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
