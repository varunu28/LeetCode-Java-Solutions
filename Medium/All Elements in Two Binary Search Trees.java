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
class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    Stack<TreeNode> stackOne = new Stack<>();
    Stack<TreeNode> stackTwo = new Stack<>();
    while (root1 != null) {
      stackOne.push(root1);
      root1 = root1.left;
    }
    while (root2 != null) {
      stackTwo.push(root2);
      root2 = root2.left;
    }
    List<Integer> list = new ArrayList<>();
    while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {
      if (!stackOne.isEmpty() && !stackTwo.isEmpty()) {
        if (stackOne.peek().val < stackTwo.peek().val) {
          TreeNode popped = stackOne.pop();
          list.add(popped.val);
          updateStack(stackOne, popped.right);
        } else {
          TreeNode popped = stackTwo.pop();
          list.add(popped.val);
          updateStack(stackTwo, popped.right);
        }
      } else if (!stackOne.isEmpty() && stackTwo.isEmpty()) {
        TreeNode popped = stackOne.pop();
        list.add(popped.val);
        updateStack(stackOne, popped.right);
      } else {
        TreeNode popped = stackTwo.pop();
        list.add(popped.val);
        updateStack(stackTwo, popped.right);
      }
    }
    return list;
  }
  
  private void updateStack(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
