class Solution {
    public String frequencySort(String s) {
        List<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }

        Map<Character, Integer> map = new HashMap<>();
        int val = 0;
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            val = Math.max(val, map.get(c));
        }

        Map<Integer, List<Character>> revMap = new HashMap<>();
        for (Character key : map.keySet()) {
            revMap.computeIfAbsent(map.get(key), k -> new ArrayList<>()).add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = val; i >= 0; i--) {
            if (revMap.containsKey(i)) {
                List<Character> characters = revMap.get(i);
                for (Character character : characters) {
                    int count = i;
                    while (count-- > 0) {
                        sb.append(character);
                    }
                }
            }
        }

        return sb.toString();
    }
}
