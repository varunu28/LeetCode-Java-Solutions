class Solution {
    public boolean queryString(String S, int N) {
        
        int num = 1;
        while (num <= N) {
            if (S.indexOf(Integer.toBinaryString(num)) == -1) {
                return false;
            }    
            
            num++;
        }
        
        return true;
    }
}
