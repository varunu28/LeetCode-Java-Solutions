/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int midLength = getLength(head)/2;
        ListNode curr = head;
        int count = 1;

        while (count < midLength) {
            curr = curr.next;
            count++;
        }

        ListNode rev = reverse(curr.next);
        curr = head;

        while (midLength-- > 1) {
            curr = curr.next;
        }

        curr.next = null;
        curr = head;

        head = merge(curr, rev);
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode ans = head1;
        ListNode pCurr = head1;
        ListNode qCurr = head2;

        ListNode pNext = null;
        ListNode qNext = null;
        ListNode pPrev = null;

        while (pCurr != null && qCurr != null) {
            pNext = pCurr.next;
            qNext = qCurr.next;

            qCurr.next = pNext;
            pCurr.next = qCurr;

            if (pNext == null) {
                pPrev = qCurr;
            }

            pCurr = pNext;
            qCurr = qNext;
        }

        pPrev.next = qCurr;

        return ans;
    }

    private static ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }
}
