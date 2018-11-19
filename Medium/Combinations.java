class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, 1, temp, ans, k);
        
        return ans;
    }
    
    private void helper(int n, int start, List<Integer> temp, List<List<Integer>> ans, int len) {
        if (temp.size() == len) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i=start; i<=n; i++) {
            // Choose
            temp.add(i);
            
            // Explore
            helper(n, i+1, temp, ans, len);
            
            // Un-choose
            temp.remove(temp.size() - 1);
        }
    }
} 
