class Solution {

    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            int weight = 0;
            for (char c : words[i].toCharArray()) {
                weight += weights[c - 'a'];
            }
            result[i] = (char) ('a' + (25 - (weight % 26)));
        }
        return String.valueOf(result);
    }
}
