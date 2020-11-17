class OrderedStream {
  int ptr;
  String[] map;
  public OrderedStream(int n) {
    map = new String[n];
    ptr = 0;
  }

  public List<String> insert(int id, String value) {
    List<String> list = new ArrayList<>();
    map[id - 1] = value;
    while (ptr < map.length && map[ptr] != null) {
      list.add(map[ptr++]);
    }
    return list;
  }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
