class LUPrefix {

  private int longestPrefixIndex;
  private boolean[] uploaded;
  
  public LUPrefix(int n) {
    this.uploaded = new boolean[n];
    this.longestPrefixIndex = 0;
  }

  public void upload(int video) {
    uploaded[video - 1] = true;
    while (longestPrefixIndex < uploaded.length && uploaded[longestPrefixIndex]) {
      longestPrefixIndex++;
    }
  }

  public int longest() {
    return longestPrefixIndex;
  }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
