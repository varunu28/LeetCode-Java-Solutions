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
    Comparator<NodePoint> nodePointComparator = (o1, o2) -> {
      int c = o2.y - o1.y;
      if (c != 0) {
        return c;
      }
      return o1.node.val - o2.node.val;
    };
    Map<Integer, PriorityQueue<NodePoint>> map = new TreeMap<>();
    Queue<NodePoint> queue = new LinkedList<>();
    queue.add(new NodePoint(0, 0, root));
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        NodePoint removed = queue.remove();
        map.computeIfAbsent(
            removed.x, k -> new PriorityQueue<>(nodePointComparator))
            .add(removed);
        if (removed.node.left != null) {
          queue.add(new NodePoint(removed.x - 1, removed.y - 1, removed.node.left));
        }
        if (removed.node.right != null) {
          queue.add(new NodePoint(removed.x + 1, removed.y - 1, removed.node.right));
        }
      }
    }
    List<List<Integer>> result = new ArrayList<>();
    for (Integer key : map.keySet()) {
      PriorityQueue<NodePoint> pq = map.get(key);
      List<Integer> temp = new ArrayList<>();
      while (!pq.isEmpty()) {
        temp.add(pq.poll().node.val);
      }
      result.add(temp);
    }
    return result;
  }
}


class NodePoint {
  int x;
  int y;
  TreeNode node;

  public NodePoint(int x, int y, TreeNode node) {
    this.x = x;
    this.y = y;
    this.node = node;
  }
}
