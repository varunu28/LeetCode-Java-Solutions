class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] update : updates) {
            ans[update[0]] += update[2];
            if (update[1] < length-1) {
                ans[update[1]+1] -= update[2];        
            }
        }
        
        int sum = 0;
        for (int i=0; i<length; i++) {
            sum += ans[i];
            ans[i] = sum;
        }
            
        return ans;
    }
}
