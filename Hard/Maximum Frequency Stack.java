class FreqStack {
    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> freqMap;
    int maxFreq;
    public FreqStack() {
        freqMap = new HashMap<>();
        map = new HashMap<>();
        maxFreq = Integer.MIN_VALUE;
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        maxFreq = Math.max(maxFreq, map.get(x));
        freqMap.computeIfAbsent(map.get(x), k -> new Stack<>()).push(x);
    }

    public int pop() {
        int popped = freqMap.get(maxFreq).pop();
        map.put(popped, map.get(popped) - 1);
        if (freqMap.get(maxFreq).size() == 0) {
            maxFreq--;
        }

        return popped;
    }
}
