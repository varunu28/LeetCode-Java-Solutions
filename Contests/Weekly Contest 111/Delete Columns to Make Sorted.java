class Solution {
    public int minDeletionSize(String[] A) {
        int delCount = 0;
        for (int i=0;i<A[0].length();i++) {
            char prev = '-';
            for (int j=0; j<A.length; j++) {
                if (j == 0) {
                    prev = A[j].charAt(i);
                }
                else {
                    if (A[j].charAt(i) < prev) {
                        delCount++;
                        break;
                    }

                    prev = A[j].charAt(i);
                }
            }
        }
        return delCount;
    }
}
