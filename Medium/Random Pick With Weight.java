class Solution {

    List<Integer> prefixSum;
    int total;
    Random rand;
    public Solution(int[] w) {
        prefixSum = new ArrayList<>();
        total = 0;
        for (int i=0; i<w.length; i++) {
            total += w[i];
            prefixSum.add(total);
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int target = rand.nextInt(total);
        int i = 0;
        int j = prefixSum.size() - 1;
        while (i != j) {
            int mid = (i+j)/2;
            if (target >= prefixSum.get(mid)) {
                i = mid + 1;
            }
            else {
                j = mid;
            }
        }
        
        return j;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
