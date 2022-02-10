class OrderedStream {
  private String[] stream;
  private int currIdx;
  public OrderedStream(int n) {
    this.stream = new String[n];
    this.currIdx = 0;
  }

  public List<String> insert(int idKey, String value) {
    this.stream[idKey - 1] = value;
    List<String> result = new ArrayList<>();
    while (this.currIdx < stream.length && this.stream[this.currIdx] != null) {
      result.add(this.stream[this.currIdx++]);
    }
    return result;
  }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
