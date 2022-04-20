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
  
  private Deque<TreeNode> stack;
  private List<Integer> arr;
  private TreeNode lastNode;
  private int pointer;
  
  public BSTIterator(TreeNode root) {
    this.stack = new ArrayDeque();
    this.arr = new ArrayList<>();
    this.lastNode = root;
    this.pointer = -1;
  }

  public boolean hasNext() {
    return !this.stack.isEmpty() || lastNode != null || this.pointer < arr.size() - 1;
  }

  public int next() {
    this.pointer++;
    if (this.pointer == this.arr.size()) {
      updateStack(lastNode);
      TreeNode curr = this.stack.pop();
      lastNode = curr.right;
      this.arr.add(curr.val);
    }
    return this.arr.get(this.pointer);
  }

  public boolean hasPrev() {
    return this.pointer > 0;
  }

  public int prev() {
    this.pointer--;
    return this.arr.get(this.pointer);
  }
  
  private void updateStack(TreeNode node) {
    while (node != null) {
      this.stack.push(node);
      node = node.left;
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
