class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList <>();
    helper(n, 0, new ArrayList<>(), ans);
    return ans;
  }

  private void helper(int n, int row, List<Integer> selections, List<List<String>> ans) {
    if (row == n) {
      ans.add(convertToString(selections, n));
    }
    else {
      for (int i = 0; i < n; i++) {
        selections.add(i);
        if (isValid(selections)) {
          helper(n, row + 1, selections, ans);
        }
        selections.remove(selections.size() - 1);
      }
    }
  }

  private List <String> convertToString(List <Integer> selections, int n) {
    List<String> ret = new ArrayList<>();
    for (int i = 0; i < selections.size(); i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < n; j++) {
        if (j == selections.get(i)) {
          sb.append("Q");
        }
        else {
          sb.append(".");
        }
      }
      ret.add(sb.toString());
    }
    return ret;
  }

  private boolean isValid(List <Integer> selections) {
    int row = selections.size() - 1;
    for (int i = 0; i < row; i++) {
      int diff = Math.abs(selections.get(i) - selections.get(row));
      if (diff == 0 || diff == row - i) {
        return false;
      }
    }
    return true;
  }
}
