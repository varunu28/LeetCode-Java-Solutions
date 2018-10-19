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
    Map<Integer, List<Integer>> map = new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        updateMap(root, 0);
        
        for (int key : map.keySet()) {
            ans.add(map.get(key));
        }
        
        return ans;
    }
    
    private void updateMap(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(root, 0));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                Element temp = queue.remove();
                if (map.containsKey(temp.level)) {
                    map.get(temp.level).add(temp.node.val);
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(temp.node.val);
                    map.put(temp.level, list);
                }
                
                if (temp.node.left != null) {
                    queue.add(new Element(temp.node.left, temp.level-1));
                }
                
                if (temp.node.right != null) {
                    queue.add(new Element(temp.node.right, temp.level+1));
                }
            }
        }
    }
}

class Element {
    public TreeNode node;
    public int level;

    public Element(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
