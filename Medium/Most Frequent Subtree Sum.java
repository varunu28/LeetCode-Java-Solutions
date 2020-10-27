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
  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> subtreeSumFrequency = new HashMap<>();
    Map<TreeNode, Integer> nodeToSum = new HashMap<>();
    dfsHelper(root, nodeToSum, subtreeSumFrequency);
    int maxFrequency = subtreeSumFrequency.values().stream()
        .max(Comparator.comparingInt(Integer::intValue)).orElseGet(() -> 0);
    return subtreeSumFrequency
        .keySet()
        .stream()
        .filter(e -> subtreeSumFrequency.get(e) == maxFrequency)
        .collect(Collectors.toList())
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }

  private int dfsHelper(TreeNode node, Map<TreeNode, Integer> nodeToSum,
      Map<Integer, Integer> subtreeSumFrequency) {
    if (node == null) {
      return 0;
    }
    if (nodeToSum.containsKey(node)) {
      return nodeToSum.get(node);
    }
    int leftSubtreeSum = dfsHelper(node.left, nodeToSum, subtreeSumFrequency);
    int rightSubtreeSum = dfsHelper(node.right, nodeToSum, subtreeSumFrequency);
    nodeToSum.put(node, node.val + leftSubtreeSum + rightSubtreeSum);
    subtreeSumFrequency
        .put(nodeToSum.get(node), subtreeSumFrequency.getOrDefault(nodeToSum.get(node), 0) + 1);
    return nodeToSum.get(node);
  }
}
