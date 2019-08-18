class Solution {
    public int countCharacters(String[] words, String chars) {
        int goodWordsLength = 0;
        Map<Character, Integer> charsMap = getMap(chars);

        for (String word : words) {
            Map<Character, Integer> wordMap = getMap(word);
            boolean allFound = true;
            for (Character character : wordMap.keySet()) {
                if (charsMap.getOrDefault(character, 0) < wordMap.get(character)) {
                    allFound = false;
                    break;
                }
            }

            if (allFound) {
                goodWordsLength +=word.length();
            }
        }


        return goodWordsLength;
    }

    private Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
}
