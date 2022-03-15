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
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> result = new ArrayList<>();
    dfs(root, target, k, result);
    return new ArrayList<>(result);
  }
  
  private int dfs(TreeNode node, TreeNode target, int k, List<Integer> result) {
    if (node == null) {
      return -1;
    }
    if (node == target) {
      addToResult(node, 0, result, k);
      return 1;
    } else {
      int left = dfs(node.left, target, k, result);
      int right = dfs(node.right, target, k, result);
      if (left != -1) {
        if (left == k) {
          result.add(node.val);
        }
        addToResult(node.right, left + 1, result, k);
        return left + 1;
      } else if (right != -1) {
        if (right == k) {
          result.add(node.val);
        }
        addToResult(node.left, right + 1, result, k);
        return right + 1;
      } else {
        return -1;
      }
    }
  }
  
  private void addToResult(TreeNode node, int dist, List<Integer> result, int k) {
    if (node == null || dist > k) {
      return;
    }
    if (dist == k) {
      result.add(node.val);
    } else {
      addToResult(node.left, dist + 1, result, k);
      addToResult(node.right, dist + 1, result, k);
    }
  }
}
