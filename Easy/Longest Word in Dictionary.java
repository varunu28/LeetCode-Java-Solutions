class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        
        Set<String> built = new HashSet<String>();
        String ans = "";
        
        for (String word : words) {
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                ans = word.length() > ans.length() ? word : ans;
                built.add(word);
            }
        }
        return ans;
    }
}
