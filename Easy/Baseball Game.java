class Solution {
    public int calPoints(String[] ops) {
        int prev = Integer.MIN_VALUE;
        int prevprev = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        int s = 0;
        int j = 0;
        
        for (int i=0;i<ops.length;i++) {
            if (ops[i].equals("D")) {
                st.push(prev*2);
                s += prev*2;
                j++;
                prevprev = prev;
                prev = st.peek();
            }
            else if (ops[i].equals("C")) {
                j--;
                int t = st.pop();
                s -= t;
                if (j == 1) {
                    prevprev = Integer.MIN_VALUE;
                    prev = st.peek();
                }
                else if (j == 0) {
                    prevprev = Integer.MIN_VALUE;
                    prev = Integer.MIN_VALUE;
                }
                else {
                    prev = st.peek();
                    int k1 = st.pop();
                    prevprev = st.pop();
                    st.push(prevprev);
                    st.push(k1);
                }
            }
            else if (ops[i].equals("+")) {
                st.push(prev + prevprev);
                s += st.peek();
                j++;
                prevprev = prev;
                prev = st.peek();
            }
            else {
                st.push(Integer.parseInt(ops[i]));
                j++;
                prevprev = prev;
                prev = st.peek();
                s += st.peek();
            }
        }
        return s;
    }
}
