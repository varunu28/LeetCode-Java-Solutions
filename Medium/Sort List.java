/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }
        
        Collections.sort(arr);
        
        curr = head;
        for (int i=0;i<arr.size();i++) {
            curr.val = arr.get(i);
            curr = curr.next;
        }
        
        return head;
    }
}
