class Solution {
    public boolean rotateString(String A, String B) {
        if (A.isEmpty() && B.isEmpty()) return true;
        int n = A.length();
        int shiftCount = 0;
        
        while(shiftCount < n) {
            if (A.equals(B)) {
                return true;
            }
            A = A.substring(1, n) + A.substring(0,1);
            shiftCount++;
        }
        
        return false;
    }
}
