/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
  Stack<TreeNode> stack;
  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    update(root);
  }
  
  private void update(TreeNode node) {
    if (node == null) {
      return;
    }
    stack.add(node);
    TreeNode leftNode = node.left;
    while (leftNode != null) {
      stack.add(leftNode);
      leftNode = leftNode.left;
    }
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.pop();
    update(node.right);
    return node.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
