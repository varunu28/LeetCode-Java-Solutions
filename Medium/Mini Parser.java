/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int idx = 0;
    public NestedInteger deserialize(String s) {
        int l = s.length();
        NestedInteger ans = new NestedInteger();
        
        while (idx < l) { 
            if (s.charAt(idx) == '-' || s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                int num = 0;
                int sign = 1;
                
                if (s.charAt(idx) == '-') {
                    sign = -1;
                    idx++;
                }
                
                while (idx < l && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                
                ans.add(new NestedInteger(num * sign));
            }
            else if (s.charAt(idx) == '[') {
                idx++;
                ans.add(deserialize(s));
            }
            else if (s.charAt(idx) == ']') {
                idx++;
                return ans;
            }
            else {
                idx++;
            }
        }
        
        return ans.getList().get(0);
    }
}
