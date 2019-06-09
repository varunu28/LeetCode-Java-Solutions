class Solution {
    public String customSortString(String S, String T) {
        int[] counter = new int[26];
        for (char c : T.toCharArray()) {
            counter[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int count = counter[c - 'a'];
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
            
            counter[c - 'a'] = 0;
        }
        
        for (char c ='a'; c <= 'z'; c++) {
            int count = counter[c - 'a'];
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
