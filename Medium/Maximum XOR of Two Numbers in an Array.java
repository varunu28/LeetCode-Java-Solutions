class Solution {
  public int findMaximumXOR(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Trie root = new Trie();
    for (int num : nums) {
      Trie curr = root;
      for (int i = 31; i >= 0; i--) {
        int currBit = (num >>> i) & 1;
        if (curr.children[currBit] == null) {
          curr.children[currBit] = new Trie();
        }
        curr = curr.children[currBit];
      }
    }
    int maxVal = Integer.MIN_VALUE;
    for (int num : nums) {
      Trie curr = root;
      int currVal = 0;
      for (int i = 31; i >= 0; i--) {
        int currBit = (num >>> i) & 1;
        if (curr.children[currBit ^ 1] != null) {
          currVal += (1 << i);
          curr = curr.children[currBit ^ 1];
        }
        else {
          curr = curr.children[currBit];
        }
      }
      maxVal = Math.max(maxVal, currVal);
    }
    return maxVal;
  }
}

class Trie {
  Trie[] children;
  public Trie() {
    children = new Trie[2];
  }
}
