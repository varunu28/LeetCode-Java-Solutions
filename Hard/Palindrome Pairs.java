class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        if (map.containsKey("")) {
            for (int i = 0; i < words.length; i++) {
                if (i == map.get("")) {
                    continue;
                }

                if (palindromeCheck(words[i])) {
                    lists.add(Arrays.asList(map.get(""), i));
                }
            }
        }

        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words[i].length(); j++) {
                String leftPart = words[i].substring(0, j);
                String rightPart = words[i].substring(j);

                if (map.containsKey(leftPart) && palindromeCheck(rightPart) && map.get(leftPart) != i) {
                    lists.add(Arrays.asList(i, map.get(leftPart)));
                }

                if (map.containsKey(rightPart) && palindromeCheck(leftPart) && map.get(rightPart) != i) {
                    lists.add(Arrays.asList(map.get(rightPart), i));
                }
            }
        }

        return lists;
    }
    
    private boolean palindromeCheck(String word) {
        int i = 0;
        int j = word.length() - 1;

        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
