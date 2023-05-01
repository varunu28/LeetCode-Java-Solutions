class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> pairs = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < text.length() - word.length() + 1; i++) {
                if (text.startsWith(word, i)) {
                    pairs.add(new int[]{i, i + word.length() - 1});
                }
            }
        }
        pairs.sort(Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        return pairs.toArray(new int[0][]);
    }
}
