class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        Set<String> match = new HashSet<>();
        Set<String> unmatch = new HashSet<>();
        
        for (String word : words) {
            if (match.contains(word)) {
                count++;
            }
            else if (unmatch.contains(word)) {
                continue;
            }
            else if (isSubsequence(word, S)) {
                match.add(word);
                count++;
            }
            else {
                unmatch.add(word);
            }
        }
        
        return count;
    }
    
    private boolean isSubsequence(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        
        int i=0;
        int j=0;
        int low = s.length();
        int high = t.length();
        
        while(i<low && j<high) {
            if (sChar[i] == tChar[j]) {
                i++;
            }
            
            j++;
        }
        
        return i == low;
    }
}
