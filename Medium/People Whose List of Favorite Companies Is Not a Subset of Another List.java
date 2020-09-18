class Solution {
  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    Map<String, Integer> map = new HashMap<>();
    List<List<Integer>> hashedList = new ArrayList<>();
    int count = 1;
    for (List<String> companies : favoriteCompanies) {
      List<Integer> temp = new ArrayList<>();
      for (String company : companies) {
        if (!map.containsKey(company)) {
          map.put(company, count++);
        }
        temp.add(map.get(company));
      }
      Collections.sort(temp);
      hashedList.add(temp);
    }
    List<Integer> foundList = new ArrayList<>();
    int n = hashedList.size();
    for (int i = 0; i < n; i++) {
      boolean found = false;
      for (int j = 0; j < n && !found; j++) {
        if (i != j) {
          List<Integer> curr = hashedList.get(j);
          List<Integer> target = hashedList.get(i);
          int idxCurr = 0;
          int idxTarget = 0;
          int sizeCurr = curr.size();
          int sizeTarget = target.size();
          while (idxCurr < sizeCurr && idxTarget < sizeTarget) {
            if (curr.get(idxCurr) == target.get(idxTarget)) {
              idxTarget++;
            }
            idxCurr++;
          }
          if (idxTarget == sizeTarget) {
            found = true;
            break;
          }
        }
      }
      if (!found) {
        foundList.add(i);
      }
    }
    return foundList;
  }
}
