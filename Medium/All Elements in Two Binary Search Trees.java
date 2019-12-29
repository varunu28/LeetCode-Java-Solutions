/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  List<Integer> ans;
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    ans = new ArrayList<>();
    helper(root1, root2);
    return ans;
  }
  
  private void helper(TreeNode r1, TreeNode r2) {
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    addToStack(stack1, r1);
    addToStack(stack2, r2);
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      TreeNode popped1 = stack1.isEmpty() ? null : stack1.pop();
      TreeNode popped2 = stack2.isEmpty() ? null : stack2.pop();
      if (popped1 != null && popped2 != null) {
        if (popped1.val > popped2.val) {
          ans.add(popped2.val);
          addToStack(stack2, popped2.right);
          stack1.push(popped1);
        }
        else {
          ans.add(popped1.val);
          addToStack(stack1, popped1.right);
          stack2.push(popped2);
        }
      }
      else if (popped2 == null) {
        ans.add(popped1.val);
        addToStack(stack1, popped1.right);
      }
      else {
        ans.add(popped2.val);
        addToStack(stack2, popped2.right);
      }
    }
  }
  
  private void addToStack(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
