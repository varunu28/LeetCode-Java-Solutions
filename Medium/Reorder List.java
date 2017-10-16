/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        
        temp = head;
        int i=0;
        int j=arr.size()-1;
        while (temp != null) {
            temp.val = arr.get(i);
            if (temp.next != null) {
                temp.next.val = arr.get(j);
                temp = temp.next.next;
            }
            else {
                temp = temp.next;
            }
            i++;
            j--;
            
        }
    }
}
