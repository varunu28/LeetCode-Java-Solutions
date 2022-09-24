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
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<NodePathSumWrapper> queue = new LinkedList<>();
    NodePathSumWrapper currNode = new NodePathSumWrapper(root, 0);
    currNode.addToPath(root.val);
    queue.add(currNode);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        NodePathSumWrapper removed = queue.remove();
        TreeNode node = removed.node;
        if (node.left == null && node.right == null) {
          if (removed.currSum == targetSum) {
            result.add(new ArrayList<>(removed.path));
          }
        } else {
          if (node.left != null) {
            NodePathSumWrapper leftNodeWrapper = new NodePathSumWrapper(node.left, removed.currSum);
            leftNodeWrapper.path.addAll(removed.path);
            leftNodeWrapper.addToPath(node.left.val);
            queue.add(leftNodeWrapper);
          }
          if (node.right != null) {
            NodePathSumWrapper rightNodeWrapper = new NodePathSumWrapper(node.right, removed.currSum);
            rightNodeWrapper.path.addAll(removed.path);
            rightNodeWrapper.addToPath(node.right.val);
            queue.add(rightNodeWrapper);
          }
        }
      }
    }
    return result;
  }
  
  private static class NodePathSumWrapper {
    TreeNode node;
    int currSum;
    List<Integer> path;
    
    public NodePathSumWrapper(TreeNode node, int currSum) {
      this.node = node;
      this.currSum = currSum;
      this.path = new ArrayList<>();
    }
    
    public void addToPath(int value) {
      this.path.add(value);
      this.currSum += value;
    }
  }
}
