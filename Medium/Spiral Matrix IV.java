/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }
        int topRow = 0;
        int bottomRow = m - 1;
        int leftColumn = 0;
        int rightColumn = n - 1;
        while (head != null) {
            for (int col = leftColumn; col <= rightColumn && head != null; col++) {
                result[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;
            for (int row = topRow; row <= bottomRow && head != null; row++) {
                result[row][rightColumn] = head.val;
                head = head.next;
            }
            rightColumn--;
            for (int col = rightColumn; col >= leftColumn && head != null; col--) {
                result[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;
            for (int row = bottomRow; row >= topRow && head != null; row--) {
                result[row][leftColumn] = head.val;
                head = head.next;
            }
            leftColumn++;
        }
        return result;
    }
}
