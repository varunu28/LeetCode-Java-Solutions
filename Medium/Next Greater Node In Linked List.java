/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode rev = reverse(head);
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        while (rev != null) {
            while (!stack.isEmpty() && stack.peek() <= rev.val) {
                stack.pop();
            }
            
            list.add(stack.isEmpty() ? 0 : stack.peek());
            stack.push(rev.val);
            rev = rev.next;
        }
        
        int[] arr = new int[list.size()];
        for (int i = 0, j=list.size() - 1; i < list.size(); i++,j--) {
            arr[i] = list.get(j);
        }
        
        return arr;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
