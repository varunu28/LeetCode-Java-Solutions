class Solution {
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    for (List<String> ticket : tickets) {
      String from = ticket.get(0);
      String to = ticket.get(1);
      map.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
    }
    Stack<String> stack = new Stack<>();
    LinkedList<String> result = new LinkedList<>();
    stack.push("JFK");
    while (!stack.isEmpty()) {
      String destination = stack.peek();
      if (!map.getOrDefault(destination, new PriorityQueue<>()).isEmpty()) {
        stack.push(map.get(destination).remove());
      } else {
        result.addFirst(stack.pop());
      }
    }
    return result;
  }
}
