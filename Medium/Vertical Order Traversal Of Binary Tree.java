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
    class NewNode {
        TreeNode t;
        int x;
        int y;
        int level;
        
        NewNode(TreeNode t, int x, int y, int level) {
            this.t = t;
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    
    int maxLeft;
    int maxRight;
    Map<Integer, List<NewNode>> map;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        maxLeft = 0;    
        maxRight = 0;
        map = new HashMap<>();
        
        helper(root, 0);
        
        List<List<Integer>> list = new ArrayList<>();
        
        while (maxLeft <= maxRight) {
            if (map.containsKey(maxLeft)) {
                List<NewNode> temp = map.get(maxLeft);
                
                Collections.sort(temp, new Comparator<NewNode>() {
                    @Override
                    public int compare(NewNode o1, NewNode o2) {
                        int c = Integer.valueOf(o1.x).compareTo(Integer.valueOf(o2.x));
                        if (c == 0) {
                            c = Integer.valueOf(o2.y).compareTo(Integer.valueOf(o1.y));
                        }
                        
                        if (c == 0) {
                            c = Integer.valueOf(o1.t.val).compareTo(Integer.valueOf(o2.t.val));
                        }
                        
                        return c;
                    }
                });
                
                List<Integer> valList = new ArrayList<>();
                for (NewNode node : temp) {
                    valList.add(node.t.val);
                }
                
                list.add(valList);
            }
            
            maxLeft++;
        }
        
        return list;
    }
    
    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        NewNode node = new NewNode(root, 0, 0, level);
        Queue<NewNode> queue = new LinkedList<>();
        
        queue.add(node);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                NewNode temp = queue.remove();
                map.computeIfAbsent(temp.level, k -> new ArrayList<>()).add(temp);
                
                maxLeft = Math.min(maxLeft, temp.level - 1);
                maxRight = Math.max(maxRight, temp.level + 1);
                
                if (temp.t.left != null) {
                    queue.add(new NewNode(temp.t.left, temp.x - 1, temp.y - 1, temp.level - 1));
                }
                
                if (temp.t.right != null) {
                    queue.add(new NewNode(temp.t.right, temp.x + 1, temp.y - 1, temp.level + 1));
                }
            }
        }
    }
}
