class FreqStack {

    Stack<Integer> stack;
    Stack<Integer> freqStack;
    Map<Integer, Integer> map;
    int maxFreq;

    public FreqStack() {
        stack = new Stack<>();
        freqStack = new Stack<>();
        map = new HashMap<>();
        maxFreq = Integer.MIN_VALUE;
    }

    public void push(int x) {
        // Everytime increment the frequency of number being pushed in the stack
        map.put(x, map.getOrDefault(x, 0) + 1);
        stack.push(x);

        // Update maxFreq if it changes after the push operation
        if (maxFreq < map.get(x)) {
            maxFreq = map.get(x);
        }

        // Push maxFreq to the freqStack to keep track of maximum frequency after each push
        freqStack.push(maxFreq);
    }

    public int pop() {

        int ans = -1;

        // If the top element in stack has the highest frequency then just return it by popping it
        if (map.get(stack.peek()) == maxFreq) {
            int temp = stack.pop();
            map.put(temp, map.getOrDefault(temp, 0) - 1);
            ans = temp;
        }
        // Traverse the stack till you find the element with frequency equal to maxFreq
        else {
            int count = 0;
            Stack<Integer> temp = new Stack<>();
            int t = -1;

            while (!stack.empty()) {
                count++;
                t = stack.pop();
                freqStack.pop();

                if (map.get(t) == maxFreq) {
                    map.put(t, map.getOrDefault(t, 0) - 1);
                    break;
                }
                else {
                    temp.push(t);
                }
            }

            // Put back the elements in the stack except the element with frequency equal to maxFreq
            while (!temp.empty()) {
                stack.push(temp.pop());
            }

            // The element with frequency equal to maxFreq
            ans = t;
            
            // Check if the freqStack had a value except the value for maxFreq which we popped
            int freqTemp = freqStack.isEmpty() ? 0 : freqStack.peek();

            // Update freqStack
            while (count-- > 0) {
                freqStack.push(freqTemp);
            }
        }
        
        freqStack.pop();
        
        // Update maxFreq
        maxFreq = stack.isEmpty() ? Integer.MIN_VALUE : freqStack.peek();
        
        return ans;
    }
}
