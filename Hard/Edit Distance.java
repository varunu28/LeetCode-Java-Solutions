class Solution {
   public int minDistance(String word1, String word2) {
        return minDistanceHelper(
                word1, 
                word2, 
                word1.length(), 
                word2.length(), 
                new Integer[word1.length() + 1][word2.length() + 1]);
    }

    private int minDistanceHelper(String word1, String word2, int word1Index, int word2Index, Integer[][] memo) {
        if (word1Index == 0) {
            return word2Index;
        }
        if (word2Index == 0) {
            return word1Index;
        }
        if (memo[word1Index][word2Index] != null) {
            return memo[word1Index][word2Index];
        }
        int minEditDistance = 0;
        if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
            minEditDistance = minDistanceHelper(word1, word2, word1Index - 1, word2Index - 1, memo);
        } else {
            int distanceWithInsertion = minDistanceHelper(word1, word2, word1Index, word2Index - 1, memo);
            int distanceWithDeletion = minDistanceHelper(word1, word2, word1Index - 1, word2Index, memo);
            int distanceWithReplace = minDistanceHelper(word1, word2, word1Index - 1, word2Index - 1, memo);
            minEditDistance = Math.min(distanceWithInsertion, 
                    Math.min(distanceWithDeletion, distanceWithReplace)) + 1;
        }
        memo[word1Index][word2Index] = minEditDistance;
        return minEditDistance;
    }
}
