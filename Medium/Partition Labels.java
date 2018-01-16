class Solution {
    public List<Integer> partitionLabels(String S) {
        
        if (S == null || S.length() == 0) return null;
        
        int[] map = new int[26];
        
        for (int i=0;i<S.length();i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        
        int end = 0;
        int start = -1;
        
        for (int i=0;i<S.length();i++) {
            end = Math.max(end, map[S.charAt(i) - 'a']);
            if (end == i) {
                ans.add(end-start);
                start = end;
            }
        }
        
        return ans;
    }
}
