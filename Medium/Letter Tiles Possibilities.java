class Solution {
    public int numTilePossibilities(String tiles) {
        int[] occCount = new int[26];
        for (char c : tiles.toCharArray()) {
            occCount[c - 'A']++;
        }
        
        return dfsHelper(occCount);
    }
    
    private int dfsHelper(int[] occCount) {
        int sum = 0;
        
        for (int i = 0; i < 26; i++) {
            if (occCount[i] == 0) {
                continue;
            }
            
            sum++;
            occCount[i]--;
            sum += dfsHelper(occCount);
            occCount[i]++;
        }
        
        return sum;
    }
}
