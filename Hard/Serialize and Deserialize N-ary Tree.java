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
  
  private static final String SEPARATOR = ",";
  private static final String NULL_NODE = "X";
  
  public String serialize(Node root) {
    if (root == null) {
      return NULL_NODE;
    }
    StringBuilder sb = new StringBuilder();
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node removed = queue.remove();
        if (removed == null) {
          sb.append(NULL_NODE).append(SEPARATOR);
          break;
        }
        for (Node child : removed.children) {
          queue.add(child);
        }
        queue.add(null);
        sb.append(removed.val).append(SEPARATOR);
      }
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    String[] splits = data.split(SEPARATOR);
    if (splits[0].equals(NULL_NODE)) {
      return null;
    }
    Node root = new Node(Integer.parseInt(splits[0]));
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    int idx = 2;
    while (idx < splits.length) {
      Node node = queue.remove();
      List<Node> children = new ArrayList<>();
      while (!splits[idx].equals(NULL_NODE)) {
        Node child = new Node(Integer.parseInt(splits[idx++]));
        children.add(child);
        queue.add(child);
      }
      idx++;
      node.children = children;
    }
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
