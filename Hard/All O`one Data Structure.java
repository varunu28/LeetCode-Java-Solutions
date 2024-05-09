class AllOne {
    private final NodeList head;
    private final NodeList tail;
    private final Map<Integer, NodeList> countToNodeMapping;
    private final Map<String, Integer> keyToCountMapping;

    public AllOne() {
        head = new NodeList(Integer.MIN_VALUE);
        tail = new NodeList(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        countToNodeMapping = new HashMap<>();
        keyToCountMapping = new HashMap<>();
    }

    public void inc(String key) {
        if (keyToCountMapping.containsKey(key)) {
            updateKey(key, 1);
        } else {
            keyToCountMapping.put(key, 1);
            if (head.next.count != 1) {
                addNodeAfter(new NodeList(1), head);
            }
            head.next.keys.add(key);
            countToNodeMapping.put(1, head.next);
        }
    }

    public void dec(String key) {
        if (keyToCountMapping.containsKey(key)) {
            int count = keyToCountMapping.get(key);
            if (count == 1) {
                keyToCountMapping.remove(key);
                removeKey(countToNodeMapping.get(count), key);
            } else {
                updateKey(key, -1);
            }
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void updateKey(String key, int diff) {
        int count = keyToCountMapping.get(key);
        keyToCountMapping.put(key, count + diff);
        NodeList currNode = countToNodeMapping.get(count);
        NodeList newNode;
        if (countToNodeMapping.containsKey(count + diff)) {
            newNode = countToNodeMapping.get(count + diff);
        } else {
            newNode = new NodeList(count + diff);
            countToNodeMapping.put(count + diff, newNode);
            // If diff == 1 then new node will have count greater than currNode else it will have count less than currNode
            addNodeAfter(newNode, diff == 1 ? currNode : currNode.prev);
        }
        newNode.keys.add(key);
        removeKey(currNode, key);
    }

    private void removeKey(NodeList nodeList, String key) {
        nodeList.keys.remove(key);
        if (nodeList.keys.isEmpty()) {
            removeNodeList(nodeList);
            countToNodeMapping.remove(nodeList.count);
        }
    }

    private void removeNodeList(NodeList nodeList) {
        nodeList.prev.next = nodeList.next;
        nodeList.next.prev = nodeList.prev;
        nodeList.next = null;
        nodeList.prev = null;
    }

    private void addNodeAfter(NodeList node, NodeList prevNode) {
        node.prev = prevNode;
        node.next = prevNode.next;
        prevNode.next.prev = node;
        prevNode.next = node;
    }

    private static class NodeList {
        int count;
        Set<String> keys;
        NodeList next;
        NodeList prev;

        public NodeList(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
