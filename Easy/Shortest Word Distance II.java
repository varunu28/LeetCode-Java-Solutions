class WordDistance {

    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();

        for (int i=0; i<words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            }
            else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);

                map.put(words[i], indexes);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> index1 = map.get(word1);
        List<Integer> index2 = map.get(word2);

        int i = 0;
        int j = 0;
        int diff = Integer.MAX_VALUE;

        while (i < index1.size() && j < index2.size()) {
            diff = Math.min(diff, Math.abs(index1.get(i) - index2.get(j)));

            if (index1.get(i) > index2.get(j)) {
                j++;
            }
            else {
                i++;
            }
        }

        return diff;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
