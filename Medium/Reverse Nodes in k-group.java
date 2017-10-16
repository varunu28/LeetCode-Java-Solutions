/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }
        
        curr = head;
        int i = 0;
        int n = k;
        while(i+k <= arr.size()) {
            while(n != 0) {
                curr.val = arr.get(i+n-1);
                curr = curr.next;
                n--;
            }
            i += k;
            n = k;
        }
        return head;
    }
}
