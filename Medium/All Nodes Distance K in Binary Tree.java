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
  List<Integer> list;
  TreeNode target;
  int K;
  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    list = new ArrayList<>();
    this.target = target;
    this.K = K;
    dfs(root);
    return list;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return -1;
    }
    else if (node == target) {
      subtreeDfs(node, 0);
      return 1;
    }
    else {
      int L = dfs(node.left);
      int R = -1;
      if (L != -1) {
        if (L == K) {
          list.add(node.val);
        }
        subtreeDfs(node.right, L + 1);
        return L + 1;
      }
      else if ((R = dfs(node.right)) != -1) {
        if (R == K) {
          list.add(node.val);
        }
        subtreeDfs(node.left, R + 1);
        return R + 1;
      }
      else {
        return -1;
      }
    }
  }
  
  private void subtreeDfs(TreeNode node, int dist) {
    if (node == null) {
      return;
    }
    if (dist == K) {
      list.add(node.val);
    }
    else if (dist > K) {
      return;
    }
    else {
      subtreeDfs(node.left, dist + 1);
      subtreeDfs(node.right, dist + 1);
    }
  }
}
