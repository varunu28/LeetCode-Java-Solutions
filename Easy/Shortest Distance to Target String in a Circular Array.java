class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int firstIdx = -1;
        int lastIdx = -1;
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                if (firstIdx == -1) {
                    firstIdx = i;
                }
                lastIdx = i;
                minDistance = Math.min(minDistance, Math.abs(i - startIndex));
            }
        }
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return Math.min(minDistance, Math.min(
            n - startIndex + firstIdx, // Reach first instance by circulating from end of array 
            startIndex + n - lastIdx // Reach last instance by circulating from start of array
        ));
    }
}
