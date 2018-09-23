class Solution {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();

            for (char c : word.toCharArray()) {
                sb.append(codes[c-'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
