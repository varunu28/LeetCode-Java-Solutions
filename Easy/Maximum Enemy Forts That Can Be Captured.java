class Solution {
    public int captureForts(int[] forts) {
        int maximumCapture = 0;
        for (int i = 0, j = 0; i < forts.length; i++) {
            if (forts[i] != 0) {
                if (forts[i] == -1 * forts[j]) {
                    maximumCapture = Math.max(maximumCapture, i - j - 1);
                }
                j = i;
            }
        }
        return maximumCapture;
    }
}
