/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
  public boolean isSubPath(ListNode head, TreeNode root) {
    if (root == null) {
      return false;
    }
    return (
      helper(head, root) ||
      isSubPath(head, root.left) ||
      isSubPath(head, root.right)
    );
  } 
  
  private boolean helper(ListNode head, TreeNode root) {
    if (head == null) {
      return true;
    }
    if (head != null && root == null) {
      return false;
    }
    if (head.val != root.val) {
      return false;
    }
    return helper(head.next, root.left) || helper(head.next, root.right);
  }
}
