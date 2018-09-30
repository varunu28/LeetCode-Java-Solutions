class Solution {
    public static List<String> wordSubsets(String[] A, String[] B) {
        Map<String, Map<Character, Integer>> map1 = getMap(A);

        Map<Character, Integer> map2 = new HashMap<>();
        for (String s : B) {
            Map<Character, Integer> temp = new HashMap<>();
            char[] tempChar = s.toCharArray();

            for (char c : tempChar) {
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
                int val1 = entry.getValue();
                int val2 = map2.getOrDefault(entry.getKey(), 0);

                map2.put(entry.getKey(), Math.max(val1, val2));
            }
        }

        List<String> ans = new ArrayList<>();

        for (String s : A) {
            boolean flag = true;
            Map<Character, Integer> temp2 = map1.get(s);

            for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
                if (!(temp2.containsKey(entry.getKey()) && temp2.get(entry.getKey()) >= entry.getValue())) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans.add(s);
            }
        }

        return ans;
    }

    private static Map<String, Map<Character, Integer>> getMap(String[] A) {
        Map<String, Map<Character, Integer>> map = new HashMap<>();

        for (String a : A) {
            char[] arr = a.toCharArray();
            Map<Character, Integer> charMap = new HashMap<>();
            for (char c : arr) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }

            map.put(a, charMap);
        }

        return map;
    }
}
