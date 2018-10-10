class MaxStack {

    /** initialize your data structure here. */
    PriorityQueue<Integer> pr;
    List<Integer> list;
    public MaxStack() {
        pr = new PriorityQueue<>((a,b) -> b-a);
        list = new ArrayList<>();
    }

    public void push(int x) {
        pr.add(x);
        list.add(x);
    }

    public int pop() {
        int res = list.get(list.size()-1);
        list.remove(list.size()-1);
        pr.remove(res);
        return res;
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int peekMax() {
        return pr.peek();
    }

    public int popMax() {
        int res = pr.poll();
        int i = list.size()-1;

        while (i >= 0) {
            if (list.get(i) == res) {
                break;
            }

            i--;
        }

        list.remove(i);

        return res;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
