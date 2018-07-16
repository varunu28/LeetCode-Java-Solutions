class Solution {
    public int binaryGap(int N) {
        char[] binValues = Integer.toBinaryString(N).toCharArray();
        int oneIndex = -1;
        int maxDistance = 0;
        
        for (int i=0; i<binValues.length; i++) {
            if (binValues[i] == '1') {
                if (oneIndex == -1) {
                    oneIndex = i;
                }
                else {
                    maxDistance = Math.max(i - oneIndex, maxDistance);
                    oneIndex = i;
                }
            }
        }
        
        return maxDistance;
    }
}
