class FreqStack {
  Map<Integer, Integer> valueToCurrentFrequency;
  Map<Integer, Stack<Integer>> frequencyToValues;
  int maxFrequency;
  public FreqStack() {
    valueToCurrentFrequency = new HashMap<>();
    frequencyToValues = new HashMap<>();
    maxFrequency = 1;
  }

  public void push(int x) {
    valueToCurrentFrequency.put(x, valueToCurrentFrequency.getOrDefault(x, 0) + 1);
    frequencyToValues.computeIfAbsent(valueToCurrentFrequency.get(x), k -> new Stack<>()).add(x);
    maxFrequency = Math.max(maxFrequency, valueToCurrentFrequency.get(x));
  }

  public int pop() {
    int val = frequencyToValues.get(maxFrequency).pop();
    valueToCurrentFrequency.put(val, valueToCurrentFrequency.getOrDefault(val, 0) - 1);
    if (frequencyToValues.get(maxFrequency).isEmpty()) {
      maxFrequency--;
    }
    return val;
  }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
