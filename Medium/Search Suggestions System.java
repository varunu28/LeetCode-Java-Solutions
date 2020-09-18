class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Node root = new Node('-');
    for (String product : products) {
      addProduct(product, root);
    }
    List<List<String>> list = new ArrayList<>();
    Node curr = root;
    boolean notFound = false;
    for (char c : searchWord.toCharArray()) {
      if (notFound) {
        list.add(new ArrayList<>());
      }
      else {
        if (!curr.children.containsKey(c)) {
          notFound = true;
          list.add(new ArrayList<>());
          continue;
        }
        curr = curr.children.get(c);
        List<String> temp = new ArrayList<>();
        PriorityQueue<String> words = new PriorityQueue<>(curr.possibleWords);
        for (int i = 0; i < 3 && !words.isEmpty(); i++) {
          temp.add(words.poll());
        }
        Collections.reverse(temp);
        list.add(temp);
      }
    }
    return list;
  }
  
  private void addProduct(String product, Node root) {
    Node curr = root;
    for (int i = 0; i < product.length(); i++) {
      if (!curr.children.containsKey(product.charAt(i))) {
        curr.children.put(product.charAt(i), new Node(product.charAt(i)));
      }
      curr = curr.children.get(product.charAt(i));
      curr.possibleWords.add(product);
      if (curr.possibleWords.size() > 3) {
        curr.possibleWords.poll();
      }
    }
  }
}


class Node {
  char c;
  Map<Character, Node> children;
  PriorityQueue<String> possibleWords;
  
  public Node(char c) {
    this.c = c;
    children = new HashMap<>();
    possibleWords = new PriorityQueue<>(Comparator.reverseOrder());
  }
}
