class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int parent = label;
        ans.add(parent);
        
        while (parent != 1) {
            int depth = (int) (Math.log(parent) / Math.log(2));
            int offset = (int) Math.pow(2, depth + 1) - 1 - parent;
            parent = ((int) Math.pow(2, depth) + offset) / 2;
            ans.add(parent);
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}
