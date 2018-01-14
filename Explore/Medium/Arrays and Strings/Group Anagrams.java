class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] ar = s.toCharArray();
            Arrays.sort(ar);
            String s_sorted = String.valueOf(ar);
            
            if (map.containsKey(s_sorted)) {
                List<String> temp = map.get(s_sorted);
                temp.add(s);
                map.put(s_sorted, temp);
            }
            else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(s_sorted, temp);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}
