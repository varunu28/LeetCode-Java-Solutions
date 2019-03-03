class Solution {
    public List<String> commonChars(String[] A) {
        int[] mainCounter = new int[26];
        Arrays.fill(mainCounter, Integer.MAX_VALUE);

        for (String str : A) {
            int[] counter = new int[26];
            for (char c : str.toCharArray()) {
                counter[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                mainCounter[i] = Math.min(mainCounter[i], counter[i]);
            }
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int count = mainCounter[i];
            char c = (char) (97 + i);

            while (count-- > 0) {
                list.add(String.valueOf(c));
            }
        }

        return list;
    }
}
