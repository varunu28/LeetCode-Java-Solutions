class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int dist1 = -1;
        int dist2 = -1;
        int minDist = Integer.MAX_VALUE;
        
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                dist1 = i;
            }
            
            if (words[i].equals(word2)) {
                dist2 = i;
            }
            
            if (dist1 != -1 && dist2 != -1) {
                minDist = Math.min(minDist, Math.abs(dist1 - dist2));
            }
        }
        
        return minDist;
    }
}
