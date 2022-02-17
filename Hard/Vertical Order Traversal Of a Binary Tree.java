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
    Map<Integer, List<TreeCoordinate>> map = new TreeMap<>();
    Queue<TreeCoordinate> queue = new LinkedList<>();
    queue.add(new TreeCoordinate(root, 0, 0));
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeCoordinate removed = queue.remove();
        map.computeIfAbsent(removed.y, k -> new ArrayList<>()).add(removed);
        if (removed.node.left != null) {
          queue.add(new TreeCoordinate(removed.node.left, removed.x + 1, removed.y - 1));
        }
        if (removed.node.right != null) {
          queue.add(new TreeCoordinate(removed.node.right, removed.x + 1, removed.y + 1));
        }
      }
    }
    List<List<Integer>> result = new ArrayList<>();
    for (Integer key : map.keySet()) {
      List<TreeCoordinate> temp = map.get(key);
      Collections.sort(temp,
          Comparator.comparingInt((TreeCoordinate o) -> o.x).thenComparingInt(o -> o.node.val));
      result.add(temp.stream().map(a -> a.node.val).collect(Collectors.toList()));
    }
    return result;
  }
  
  private static class TreeCoordinate {
    
    public TreeNode node;
    public int x;
    public int y;
    
    public TreeCoordinate(TreeNode node, int x, int y) {
      this.node = node;
      this.x = x;
      this.y = y;
    }
  }
}
