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
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> temp = new ArrayList<>();
      while (size-- > 0) {
        TreeNode removed = queue.remove();
        temp.add(removed.val);
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
      list.add(temp);
    }
    Collections.reverse(list);
    return list;
  }
}
