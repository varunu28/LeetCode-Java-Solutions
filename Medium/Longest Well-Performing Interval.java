class Solution {
    public int longestWPI(int[] hours) {
        int ans = 0;
        int[] preComputed = new int[hours.length + 1];
        
        for (int i = 1; i < preComputed.length; i++) {
            if (hours[i - 1] > 8) {
                ans = 1;
                preComputed[i] = preComputed[i - 1] + 1;
            }
            else {
                preComputed[i] = preComputed[i - 1] - 1;
            }
        }
        
        for(int i = 0; i <= hours.length; i++){
            for(int j = hours.length; j > i; j--){
                if(preComputed[j]-preComputed[i] > 0){
                    ans = Math.max(ans, j - i);
                    break;
                }
            }
        }
        
        return ans;
    }
}
