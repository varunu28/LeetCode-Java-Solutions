public class ZigzagIterator {
    
    List<Integer> l1;
    List<Integer> l2;
    int start1;
    int start2;
    int end1;
    int end2;
    boolean flag;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l1 = v1;
        l2 = v2;
        start1 = 0;
        start2 = 0;
        end1 = l1.size();
        end2 = l2.size();
        flag = true;
    }

    public int next() {
        if (start1 < end1 && start2 < end2) {
            int ans = -1;
            if (flag) {
                ans = l1.get(start1);
                start1++;
                flag = !flag;
            }
            else {
                ans = l2.get(start2);
                start2++;
                flag = !flag;
            }
            
            return ans;
        }
        else if (start1 < end1) {
            return l1.get(start1++);
        }
        else {
            return l2.get(start2++);
        }
    }

    public boolean hasNext() {
        return !(start1 == end1 && start2 == end2);
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
