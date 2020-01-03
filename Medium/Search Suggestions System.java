class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> ans = new ArrayList<>();
    List<String> prev = new ArrayList<>();
    for (int i = 0; i < searchWord.length(); i++) {
      List<String> curr = new ArrayList<>();
      List<String> temp = new ArrayList<>();
      PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
      if (i == 0) {
        helper(Arrays.asList(products), searchWord, i, curr, pq);
      }
      else {
        helper(prev, searchWord, i, curr, pq);
      }
      while (!pq.isEmpty()) {
        temp.add(pq.poll());
      }
      Collections.sort(temp);
      ans.add(temp);
      prev = curr;
    }
    return ans;
  }

  private void helper(List<String> products, String searchWord, int i, List<String> curr, PriorityQueue<String> pq) {
    for (String word : products) {
      if (i < word.length() && word.charAt(i) == searchWord.charAt(i)) {
        curr.add(word);
        pq.add(word);
        if (pq.size() > 3) {
          pq.poll();
        }
      }
    }
  }
}
