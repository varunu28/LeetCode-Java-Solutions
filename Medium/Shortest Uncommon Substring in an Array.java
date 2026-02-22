class Solution {
    public String[] shortestSubstrings(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            Set<String> uniqueSubstrings = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    uniqueSubstrings.add(s.substring(i, j));
                }
            }
            for (String sub : uniqueSubstrings) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            List<String> substrings = new ArrayList<>();
            for (int j = 0; j < arr[i].length(); j++) {
                for (int k = j + 1; k <= arr[i].length(); k++) {
                    if (map.get(arr[i].substring(j, k)) == 1) {
                        substrings.add(arr[i].substring(j, k));
                    }
                }
            }
            if (substrings.isEmpty()) {
                result[i] = "";
            } else if (substrings.size() == 1) {
                result[i] = substrings.get(0);
            } else {
                Collections.sort(substrings);
                int resultIdx = 0;
                for (int idx = 1; idx < substrings.size(); idx++) {
                    if (substrings.get(idx).length() < substrings.get(resultIdx).length()) {
                        resultIdx = idx;
                    }
                }
                result[i] = substrings.get(resultIdx);
            }
        }
        return result;
    }
}
