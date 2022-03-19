class FreqStack {
  
  private Map<Integer, Integer> frequencyMap;
  private Map<Integer, Stack<Integer>> frequencyGroup;
  private int maxFrequency;
  
  public FreqStack() {
    this.frequencyMap = new HashMap<>();
    this.frequencyGroup = new HashMap<>();
    this.maxFrequency = 0;
  }

  public void push(int val) {
    int newFrequency = this.frequencyMap.getOrDefault(val, 0) + 1;
    this.frequencyMap.put(val, newFrequency);
    this.maxFrequency = Math.max(this.maxFrequency, newFrequency);
    this.frequencyGroup.computeIfAbsent(newFrequency, k -> new Stack<>()).push(val);
  }

  public int pop() {
    int val = this.frequencyGroup.get(this.maxFrequency).pop();
    this.frequencyMap.put(val, this.frequencyMap.get(val) - 1);
    if (this.frequencyGroup.get(this.maxFrequency).isEmpty()) {
      this.maxFrequency--;
    }
    return val;
  }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
