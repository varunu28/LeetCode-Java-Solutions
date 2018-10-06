/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int index;
    int size;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        index = 0;
        for (NestedInteger n : nestedList) {
            dfsHelper(n);
        }
        
        size = list.size();
    }
    
    private void dfsHelper(NestedInteger n) {
        if (n.isInteger()) {
            list.add(n.getInteger());
        }
        else {
            for (NestedInteger ni : n.getList()) {
                dfsHelper(ni);
            }
        }
    }

    @Override
    public Integer next() {
        if (index < size) {
            return list.get(index++);
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        return !(index == size);        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
