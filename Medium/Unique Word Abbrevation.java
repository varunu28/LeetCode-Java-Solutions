class ValidWordAbbr {

    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();

        for (String word : dictionary) {
            String abbr = getAbbr(word);
            if (map.containsKey(abbr)) {
                if (!map.get(abbr).equals(word)) {
                    map.put(abbr, "");
                }
            }
            else {
                map.put(abbr, word);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }

    private String getAbbr(String word) {
        if (word.length() <= 2) {
            return word;
        }

        int num = word.length() - 2;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0)).append(String.valueOf(num)).append(word.charAt(word.length()-1));

        return sb.toString();
    }
}


/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
