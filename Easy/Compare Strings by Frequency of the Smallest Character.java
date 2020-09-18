class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        List<Integer> list = new ArrayList<>();
        for (String word : words) {
            list.add(getMinWordFreq(word));
        }
        Collections.sort(list);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int minCount = getMinWordFreq(queries[i]);
            int idx = 0;
            ans[i] = binarySearch(minCount, list);
        }
        return ans;
    }
    
    private int binarySearch(int target, List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return list.size() - left;
    }
    
    private int getMinWordFreq(String word) {
        int[] counter = new int[26];
        for (char c : word.toCharArray()) {
            counter[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0) {
                return counter[i];
            }
        }
        return 0;
    }
}
