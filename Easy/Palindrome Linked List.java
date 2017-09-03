/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        
        if (arr.size() < 2) return true;
    
        int i=0;
        int j = arr.size()-1;
        
        while (true) {
            
            if (arr.get(i).equals(arr.get(j)) == false) return false;
            
            if (arr.size()%2 == 0 && j - i == 1) break;
            if (arr.size()%2 != 0 && j - i == 2) break;
            
            i++;
            j--;
        }
        return true;
    }
}
