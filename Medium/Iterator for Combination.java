class CombinationIterator {
  List<String> list;
  Iterator<String> iter;
  public CombinationIterator(String characters, int combinationLength) {
    list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(characters, sb, 0, combinationLength);
    iter = list.iterator();
  }
  
  private void helper(String characters, StringBuilder sb, int idx, int combinationLength) {
    if (sb.length() == combinationLength) {
      list.add(new String(sb.toString()));
    }
    else if (idx == characters.length() || sb.length() > combinationLength) {
      return;
    }
    else {
      for (int i = idx; i < characters.length(); i++) {
        sb.append(characters.charAt(i));
        helper(characters, sb, i + 1, combinationLength);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

  public String next() {
    return iter.next();
  }

  public boolean hasNext() {
    return iter.hasNext();
  }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
