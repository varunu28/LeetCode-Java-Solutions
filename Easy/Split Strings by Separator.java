class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int startIdx = 0;
            int currIdx = 0;
            while (currIdx < word.length()) {
                if (word.charAt(currIdx) == separator) {
                    if (currIdx - startIdx > 0) {
                        result.add(word.substring(startIdx, currIdx));
                    }
                    startIdx = currIdx + 1;
                }
                currIdx++;
            }
            if (currIdx - startIdx > 0) {
                result.add(word.substring(startIdx, currIdx));
            }
        }
        return result;
    }
}
