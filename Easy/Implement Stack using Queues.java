import java.util.ArrayList;

class MyStack {

    /** Initialize your data structure here. */
    ArrayList<Integer> arrNew = new ArrayList<>();
    ArrayList<Integer> arrOld = new ArrayList<>();


    /** Push element x onto stack. */
    public void push(int x) {
        arrOld.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i=0;i<=arrOld.size()-1;i++) {
            arrNew.add(arrOld.get(i));
        }
        int k = arrNew.get(arrNew.size()-1);
        arrNew.remove(arrNew.indexOf(k));

        arrOld.clear();
        return k;
    }

    /** Get the top element. */
    public int top() {
        for (int i=0;i<=arrOld.size()-1;i++) {
            arrNew.add(arrOld.get(i));
        }
        int k = arrNew.get(arrNew.size()-1);

        arrOld.clear();
        return k;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return arrNew.size() == 0 && arrOld.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
