class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist1 = -1;
        int dist2 = -1;
        int minDist = Integer.MAX_VALUE;
        
        boolean sameWord = word1.equals(word2);
        
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                if (sameWord) {
                    if (dist1 == -1) {
                        dist1 = i;
                    }
                }
                else {
                    dist1 = i;
                }
            }
            
            if (words[i].equals(word2)) { 
                if (sameWord) {
                    if (i != dist1) {
                        dist2 = i;
                    }
                }
                else {
                    dist2 = i;
                }
            }
            
            if (dist1 != -1 && dist2 != -1) {
                minDist = Math.min(minDist, Math.abs(dist1 - dist2));
                if (sameWord) {
                    dist1 = dist2;
                    dist2 = -1;
                }
            }
        }
        
        return minDist;
    }
}
