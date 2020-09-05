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
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    updateStack(stack1, root1);
    updateStack(stack2, root2);
    List<Integer> list = new ArrayList<>();
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      if (!stack1.isEmpty() && !stack2.isEmpty()) {
        if (stack1.peek().val < stack2.peek().val) {
          TreeNode popped = stack1.pop();
          list.add(popped.val);
          updateStack(stack1, popped.right);
        }
        else {
          TreeNode popped = stack2.pop();
          list.add(popped.val);
          updateStack(stack2, popped.right);
        }
      }
      else if (!stack1.isEmpty() && stack2.isEmpty()) {
        TreeNode popped = stack1.pop();
        list.add(popped.val);
        updateStack(stack1, popped.right);
      }
      else {
        TreeNode popped = stack2.pop();
        list.add(popped.val);
        updateStack(stack2, popped.right);
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
