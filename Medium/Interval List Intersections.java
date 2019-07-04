class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intersections = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;
    
        while (idx1 < A.length && idx2 < B.length) {
            if (A[idx1][0] > B[idx2][1]) {
                idx2++;
                continue;
            }
            
            if (A[idx1][1] < B[idx2][0]) {
                idx1++;
                continue;
            }
            
            int maxStart = Math.max(A[idx1][0], B[idx2][0]);
            int minEnd = Math.min(A[idx1][1], B[idx2][1]);
            
            int[] interval = {maxStart, minEnd};
            intersections.add(interval);
            
            if (A[idx1][1] > B[idx2][1]) {
                idx2++;
            }
            else {
                idx1++;
            }
        }
        
        int[][] ans = new int[intersections.size()][2];
        for (int i = 0; i < intersections.size(); i++) {
            ans[i] = intersections.get(i);
        }
        
        return ans;
    }
}
