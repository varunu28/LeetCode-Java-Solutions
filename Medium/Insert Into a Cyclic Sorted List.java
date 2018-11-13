/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node temp = new Node(insertVal);
        if (head == null) {
            temp.next = temp;
            return temp;
        }
        
        Node prev = head;
        Node curr = head.next;
        
        while (curr != head) {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                break;   
            }
            
            if (prev.val > curr.val) {
                if (insertVal <= curr.val || insertVal >= prev.val) {
                    break;   
                }
            }
            
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = temp;
        temp.next = curr;
        
        return head;
    }
}
