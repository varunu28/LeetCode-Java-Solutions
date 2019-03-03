class Solution {
    public int longestOnes(int[] A, int K) {
        int slow = 0;
        int fast = 0;
        int count = 0;
        int end = A.length;
        int maxLen = 0;

        while (fast < end) {
            if (A[fast] != 1) {
                count++;
            }

            while (count > K && slow < end) {
                if (A[slow] == 0) {
                    count--;
                }

                slow++;
            }

            fast++;

           if (fast - slow > maxLen) {
               maxLen = fast - slow;
           }
        }

        return maxLen;
    }
}
