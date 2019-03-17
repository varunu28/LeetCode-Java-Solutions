class Solution {
    public String nextClosestTime(String time) {
        char[] timeDigits = time.toCharArray();
        char[] sorted = time.toCharArray();
        Arrays.sort(sorted);
        
        timeDigits[4] = findNext(timeDigits[4], (char)('9' + 1), sorted);
        if (timeDigits[4] > time.charAt(4)) {
            return String.valueOf(timeDigits);
        }
        
        timeDigits[3] = findNext(timeDigits[3], '5', sorted);
        if (timeDigits[3] > time.charAt(3)) {
            return String.valueOf(timeDigits);
        }
        
        timeDigits[1] = timeDigits[0] == '2' ? 
                                findNext(timeDigits[1], '3', sorted) : 
                                findNext(timeDigits[1], (char)('9' + 1), sorted);
        if (timeDigits[1] > time.charAt(1)) {
            return String.valueOf(timeDigits);
        }
        
        timeDigits[0] = findNext(timeDigits[0], '2', sorted);
        
        return String.valueOf(timeDigits);
    }
    
    private char findNext(char current, char limit, char[] sorted) {
        if (current == limit) {
            return sorted[0];
        }
        
        int pos = Arrays.binarySearch(sorted, current) + 1;
        
        while (pos < 4 && (sorted[pos] > limit || sorted[pos] == current)) {
            pos++;
        }
        
        return pos == 4 ? sorted[0] : sorted[pos];
    }
}
