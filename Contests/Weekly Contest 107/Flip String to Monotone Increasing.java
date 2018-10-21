class Solution {
    public static int minFlipsMonoIncr(String S) {
        int zeroCount = 0;
        int flipCount = 0;
        int oneCount = 0;
        
        for (char c : S.toCharArray()) {
            if (c == '0') {
                if (oneCount == 0) {
                    continue;
                }
                else {
                    flipCount++;
                }
            }
            else {
                oneCount++;
            }
            
            if (flipCount > oneCount) {
                flipCount = oneCount;
            }
        }
        
        return flipCount;
    }
}
