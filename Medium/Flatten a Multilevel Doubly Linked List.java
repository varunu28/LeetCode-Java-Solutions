/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    Node ans;
    Node curr;
    public Node flatten(Node head) {
        ans = new Node(-1);
        curr = ans;
        
        helper(head);
        
        return ans.next;
    }
    
    private void helper(Node node) {
        if (node == null) {
            return;
        }
        
        Node prev = curr;
        curr.next = new Node(node.val);
        curr = curr.next;
        curr.prev = prev.val == -1 ? null : prev;
        
        if (node.child != null) {
            helper(node.child);
        }
        
        helper(node.next);
    }
}
