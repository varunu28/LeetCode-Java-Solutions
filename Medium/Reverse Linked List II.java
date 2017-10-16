/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }
        
        curr = head;
        int i=1;
        int j=n-1;
        while(curr != null) {
            if (i>=m && i<=n) {
                curr.val = arr.get(j);
                j--;
            }
            curr = curr.next;
            i++;
        }
        return head;
    }
}
