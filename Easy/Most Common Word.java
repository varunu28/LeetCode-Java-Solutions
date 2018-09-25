class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        List<String> bannedWords = Arrays.asList(banned);

        String[] words = paragraph.trim().split("\\s+");
        Map<String, Integer> map = new LinkedHashMap<>();
        int maxValue = Integer.MIN_VALUE;

        for (String word : words) {

            if (!Character.isAlphabetic(word.charAt(word.length()-1))) {
                word = word.substring(0, word.length()-1);
            }

            if (!(word.equals(" ") || word.equals("")) && bannedWords.indexOf(word) == -1) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                maxValue = Math.max(maxValue, map.get(word));
            }
        }

        for (String word : map.keySet()) {
            if (map.get(word) == maxValue) {
                return word;
            }
        }

        return "";
    }
}
