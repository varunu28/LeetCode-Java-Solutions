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
class BSTIterator {

    private final Deque<TreeNode> primary;
    private final List<Integer> secondary;
    private int index;

    public BSTIterator(TreeNode root) {
        this.primary = new ArrayDeque<>();
        this.secondary = new ArrayList<>();
        this.index = -1;
        traverse(root);
    }
    
    public boolean hasNext() {
        return !primary.isEmpty() || index < secondary.size() - 1;
    }
    
    public int next() {
        index++;
        if (index == secondary.size()) {
            TreeNode curr = primary.pop();
            secondary.add(curr.val);
            traverse(curr.right);
        }
        return secondary.get(index);
    }
    
    public boolean hasPrev() {
        return index > 0;
    }
    
    public int prev() {
        index--;
        return secondary.get(index);
    }

    private void traverse(TreeNode root) {
        while (root != null) {
            primary.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */
