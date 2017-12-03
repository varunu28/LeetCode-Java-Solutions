class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split("\\s+");

        Map<Character, String> patMap = new HashMap<>();
        Map<String, String> strMap = new HashMap<>();

        for (int i=0;i<pattern.length();i++) {
            if (patMap.containsKey(pattern.charAt(i))) {
                patMap.put(pattern.charAt(i), patMap.get(pattern.charAt(i)) + String.valueOf(i));
            }
            else {
                patMap.put(pattern.charAt(i), String.valueOf(i));
            }
        }

        for (int i=0;i<arr.length;i++) {
            if (strMap.containsKey(arr[i])) {
                strMap.put(arr[i], strMap.get(arr[i]) + String.valueOf(i));
            }
            else {
                strMap.put(arr[i], String.valueOf(i));
            }
        }

        if (patMap.size() != strMap.size()) {
            return false;
        }

        for (int i=0;i<pattern.length();i++) {
            if (!patMap.get(pattern.charAt(i)).equals(strMap.get(arr[i]))) {
                return false;
            }
        }

        return true;
    }

}
