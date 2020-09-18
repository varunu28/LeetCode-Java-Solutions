class Solution {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        for (char c : S.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
