class LRUCache {

    Map<Integer, Node> map;
    Node head, tail;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        head = new Node();
        head.previous = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.previous = head;

        this.count = 0;
    }

    public int get(int key) {
        Node node = map.get(key);

        if (node == null) {
            return -1;
        }

        moveToHead(node);
        
        return node.val;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        node.previous = head;
        node.next = head.next;

        head.next.previous = node;
        head.next = node;
    }

    private Node popTail() {
        Node res = tail.previous;
        removeNode(res);

        return res;
    }

    private void removeNode(Node node) {
        Node pre = node.previous;
        Node post = node.next;

        pre.next = post;
        post.previous = pre;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            map.put(key, newNode);
            addNode(newNode);

            count++;

            if (count > capacity) {
                Node tail = popTail();
                map.remove(tail.key);
                count--;
            }
        }
        else {
            node.val = value;
            moveToHead(node);
        }
    }

    private class Node {
        Node previous;
        Node next;
        int key;
        int val;
    }
}

