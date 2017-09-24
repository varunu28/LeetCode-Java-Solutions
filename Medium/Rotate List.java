/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void rotateArr(int[] arr) {
        int temp = arr[0];
        for (int i=1;i<arr.length;i++) {
            int t = arr[i];
            arr[i] = temp;
            temp = t;
        }
        
        arr[0] = temp;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int l = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            l++;
        }
        
        int[] arr = new int[l];
        curr = head;
        
        for (int i=0;i<l;i++) {
            arr[i] = curr.val;
            curr = curr.next;
        }
        
        k = k%l;
        
        while (k > 0) {
            rotateArr(arr);
            k--;
        }
    
        curr = head;
        int j = 0;
        while (curr != null) {
            curr.val = arr[j];
            j++;
            curr = curr.next;
        }
        
        return head;
    }
}
