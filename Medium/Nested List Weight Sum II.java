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
    int maxDepth;
    int sum;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        maxDepth = 0;
        maxDepthHelper(nestedList, 1);
        
        sum = 0;
        helper(nestedList, maxDepth);
        
        return sum;
    }
    
    private void helper(List<NestedInteger> nestedList, int level) {
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                sum += nested.getInteger() * level;
            }
            else {
                helper(nested.getList(), level - 1);
            }
        }
    }
    
    private void maxDepthHelper(List<NestedInteger> nestedList, int currLevel) {
        maxDepth = Math.max(maxDepth, currLevel);
        
        for (NestedInteger nestedInteger : nestedList) {
            if (!nestedInteger.isInteger()) {
                maxDepthHelper(nestedInteger.getList(), currLevel + 1);
            }
        }
    }
}
