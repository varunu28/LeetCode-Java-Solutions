class Solution {
  public List<Integer> minSubsequence(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    int totalSum = 0;
    for (int num : nums) {
      pq.add(num);
      totalSum += num;
    }
    List<Integer> list = new ArrayList<>();
    int currSum = 0;
    while (currSum <= totalSum) {
      int num = pq.poll();
      currSum += num;
      totalSum -= num;
      list.add(num);
    }
    return list;
  }
}
