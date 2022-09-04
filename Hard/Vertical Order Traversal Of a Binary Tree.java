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
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    Map<Integer, List<NodePair>> map = new HashMap<>();
    Queue<NodePair> queue = new LinkedList<>();
    queue.add(new NodePair(0, 0, root));
    int minColumn = 0;
    int maxColumn = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        NodePair removed = queue.remove();
        minColumn = Math.min(minColumn, removed.y);
        maxColumn = Math.max(maxColumn, removed.y);
        map.computeIfAbsent(removed.y, k -> new ArrayList<>()).add(removed);
        if (removed.node.left != null) {
          queue.add(new NodePair(removed.x + 1, removed.y - 1, removed.node.left));
        }
        if (removed.node.right != null) {
          queue.add(new NodePair(removed.x + 1, removed.y + 1, removed.node.right));
        }
      }
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int key = minColumn; key <= maxColumn; key++) {
      List<NodePair> list = map.get(key);
      result.add(list.stream()
                 .sorted(Comparator.comparingInt((NodePair o) -> o.x).thenComparingInt(o -> o.node.val))
                 .map(np -> np.node.val)
                 .collect(Collectors.toList()));
    }
    return result;
  }
  
  class NodePair {
    int x;
    int y;
    TreeNode node;
    
    public NodePair(int x, int y, TreeNode node) {
      this.x = x;
      this.y = y;
      this.node = node;
    }
  }
}
