class Solution {
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    Map<Integer, List<Node>> graph = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      Node node1 = new Node(edges[i][1], succProb[i]);
      Node node2 = new Node(edges[i][0], succProb[i]);
      graph.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(node1);
      graph.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(node2);
    }
    double[] probs = new double[n];
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(start, 1.0));
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      int parent = node.val;
      double prob = node.prob;
      for (Node child : graph.getOrDefault(parent, new ArrayList<>())) {
        if (probs[child.val] >= prob * child.prob) {
          continue;
        }
        queue.add(new Node(child.val, prob * child.prob));
        probs[child.val] = prob * child.prob;
      }
    }
    return probs[end];
  }
}


class Node {
  int val;
  double prob;
  
  public Node(int val, double prob) {
    this.val = val;
    this.prob = prob;
  }
}
