class WordDictionary {

  /** Initialize your data structure here. */
  Node root;
  public WordDictionary() {
    root = new Node('-');
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    Node curr = root;
    for (char c : word.toCharArray()) {
      if (curr.children[c - 'a'] == null) {
        curr.children[c - 'a'] = new Node(c);
      }
      curr = curr.children[c - 'a'];
    }
    curr.isWord = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    Node curr = root;
    return searchHelper(curr, word, 0);
  }
  
  private boolean searchHelper(Node curr, String word, int idx) {
    if (idx == word.length()) {
      return curr.isWord;
    }
    char c = word.charAt(idx);
    if (c != '.') {
      if (curr.children[c - 'a'] == null) {
        return false;
      }
      return searchHelper(curr.children[c - 'a'], word, idx + 1);
    }
    else {
      boolean flag = false;
      for (Node child : curr.children) {
        if (child != null) {
          flag = flag | searchHelper(child, word, idx + 1);
        }
      }
      return flag;
    }
  }
}


class Node {
  char c;
  Node[] children;
  boolean isWord;
  
  public Node(char c) {
    this.c = c;
    children = new Node[26];
    isWord = false;
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
