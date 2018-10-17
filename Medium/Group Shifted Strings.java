class Solution {
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = getKey(s);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }

    private static String getKey(String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i=1; i<s.length(); i++) {
            int diff = s.charAt(i) - s.charAt(i-1);
            diff = diff < 0 ? diff + 26 : diff;

            sb.append(diff);
        }

        return sb.toString();
    }
}
