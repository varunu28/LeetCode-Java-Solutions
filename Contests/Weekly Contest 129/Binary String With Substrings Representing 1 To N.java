class Solution {
    public boolean queryString(String S, int N) {
        
        int num = N;
        while (num >= N / 2) {
            if (S.indexOf(Integer.toBinaryString(num)) == -1) {
                return false;
            }    
            
            num--;
        }
        
        return true;
    }
}
