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
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Map<Integer, List<TreeLevel>> map = new TreeMap<>();
    Queue<TreeLevel> queue = new LinkedList<>();
    queue.add(new TreeLevel(root, 0, 0));
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeLevel removed = queue.remove();
        map.computeIfAbsent(removed.xLevel, k -> new ArrayList<>()).add(removed);
        if (removed.node.left != null) {
          queue.add(new TreeLevel(removed.node.left, removed.xLevel - 1, removed.yLevel - 1));
        }
        if (removed.node.right != null) {
          queue.add(new TreeLevel(removed.node.right, removed.xLevel + 1, removed.yLevel - 1));
        }
      }
    }
    List<List<Integer>> list = new ArrayList<>();
    for (Integer key : map.keySet()) {
      List<TreeLevel> temp = map.get(key);
      Collections.sort(temp, new Comparator<TreeLevel>(){
        public int compare(TreeLevel t1, TreeLevel t2) {
          int c = t2.yLevel - t1.yLevel;
          if (c == 0) {
            c = t1.node.val - t2.node.val;
          }
          return c;
        }
      });
      List<Integer> valTemp = new ArrayList<>();
      for (TreeLevel t : temp) {
        valTemp.add(t.node.val);
      }
      list.add(valTemp);
    }
    return list;
  }
}

class TreeLevel {
  TreeNode node;
  int xLevel;
  int yLevel;
  
  public TreeLevel(TreeNode node, int xLevel, int yLevel) {
    this.node = node;
    this.xLevel = xLevel;
    this.yLevel = yLevel;
  }
}
