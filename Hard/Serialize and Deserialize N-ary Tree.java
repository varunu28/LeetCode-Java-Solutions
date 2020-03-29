/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {
    
  // Encodes a tree to a single string.
  private final String SEPARATOR = ",";
  private final String NULL_SEPARATOR = "#";
  public String serialize(Node root) {
    StringBuilder sb = new StringBuilder();
    serializeHelper(root, sb);
    return sb.toString();
  }
  
  private void serializeHelper(Node root, StringBuilder sb) {
    if (root == null) {
      sb.append(NULL_SEPARATOR).append(SEPARATOR);
    }
    else {
      sb.append(root.val).append(SEPARATOR).append(root.children.size()).append(SEPARATOR);
      for (Node child : root.children) {
        serializeHelper(child, sb);
      }
    }
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    Deque<String> dq = new ArrayDeque<>(Arrays.asList(data.split(SEPARATOR)));
    return deserializeHelper(dq);
  }
  
  private Node deserializeHelper(Deque<String> dq) {
    String removed = dq.removeFirst();
    if (removed.equals(NULL_SEPARATOR)) {
      return null;
    }
    else {
      Node node = new Node(Integer.parseInt(removed), new ArrayList<>());
      int childCount = Integer.parseInt(dq.removeFirst());
      for (int i = 0; i < childCount; i++) {
        node.children.add(deserializeHelper(dq));
      }
      return node;
    }
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
