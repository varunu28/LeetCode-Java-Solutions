class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int maxIdx = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            maxIdx = Math.max(map.get(s.charAt(i)), maxIdx);
            if (maxIdx == i) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
