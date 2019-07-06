/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        
        sb = new StringBuilder();
        serializeHelper(root);
        
        return sb.toString().substring(0, sb.length() - 1);
    }
    
    private void serializeHelper(Node root) {        
        if (root == null) {
            return;
        }
        
        sb.append(root.val).append(",").append(root.children.size()).append(",");
        for (Node child : root.children) {
            serializeHelper(child);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        
        return deserializeHelper(queue);
    }
    
    private Node deserializeHelper(Queue<String> queue) {
        Node root = new Node();
        root.val = Integer.parseInt(queue.remove());
        int size = Integer.parseInt(queue.remove());
        
        root.children = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(queue));
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
