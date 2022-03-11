/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
  public NodeCopy copyRandomBinaryTree(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    Map<Node, NodeCopy> map = new HashMap<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        Node removed = queue.remove();
        map.put(removed, new NodeCopy(removed.val));
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        Node removed = queue.remove();
        if (removed.left != null) {
          queue.add(removed.left);
          map.get(removed).left = map.get(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
          map.get(removed).right = map.get(removed.right);
        }
        if (removed.random != null) {
          map.get(removed).random = map.get(removed.random);
        }
      }
    }
    return map.get(root);
  }
}
