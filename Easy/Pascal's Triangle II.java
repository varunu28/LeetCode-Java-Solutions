class Solution {
  public List<Integer> getRow(int rowIndex) {
    int count = 0;
    List<Integer> list = new ArrayList<>();
    List<Integer> prev = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      prev = list;
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          temp.add(1);
        }
        else {
          temp.add(prev.get(j - 1) + prev.get(j));
        }
      }
      list = temp;
    }
    return list;
  }   
}
