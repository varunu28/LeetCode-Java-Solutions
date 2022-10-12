/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  private static final String NULL_VALUE = "-";
  private static final String DELIMETER = " ";
  
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return NULL_VALUE;
    }
    StringBuilder sb = new StringBuilder();
    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode removed = stack.pop();
      if (removed == null) {
        sb.append(NULL_VALUE).append(DELIMETER);
        continue;      
      }
      sb.append(removed.val).append(DELIMETER);
      stack.push(removed.right);
      stack.push(removed.left);
    }
    return sb.toString().trim();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split("\\s+")));
    return helper(queue);
  }
  
  private TreeNode helper(Queue<String> queue) {
    if (queue.peek().equals(NULL_VALUE)) {
      queue.remove();
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(queue.peek()));
    queue.remove();
    root.left = helper(queue);
    root.right = helper(queue);
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
