class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    TrieNode root = new TrieNode();
    for (String prod : products) {
      TrieNode curr = root;
      for (char c : prod.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          curr.children[c - 'a'] = new TrieNode();
        }
        curr = curr.children[c - 'a'];
        curr.matchingProducts.add(prod);
      }
    }
    List<List<String>> result = new ArrayList<>();
    TrieNode curr = root;
    for (char c : searchWord.toCharArray()) {
      if (curr == null) {
        result.add(new ArrayList<>());
      } else {
        if (curr.children[c - 'a'] == null) {
          curr = null;
          result.add(new ArrayList<>());
        } else {
          curr = curr.children[c - 'a'];
          PriorityQueue<String> currMatchingProductsQueue = new PriorityQueue<>(curr.matchingProducts);
          List<String> currMatchingProducts = new ArrayList<>();
          while (!currMatchingProductsQueue.isEmpty() && currMatchingProducts.size() < 3) {
            currMatchingProducts.add(currMatchingProductsQueue.poll());
          }
          result.add(currMatchingProducts);
        }
      }
    }
    return result;
  }
  
  private class TrieNode {
    TrieNode[] children;
    PriorityQueue<String> matchingProducts;
    
    public TrieNode() {
      this.children = new TrieNode[26];
      this.matchingProducts = new PriorityQueue<>();
    }
  }
}
