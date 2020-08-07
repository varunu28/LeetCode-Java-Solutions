class Solution {
  public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
    int n = quality.length;
    Worker[] workers = new Worker[n];
    for (int i = 0; i < n; i++) {
      workers[i] = new Worker(quality[i], wage[i]);
    }
    Arrays.sort(workers);
    double ans = 1e9;
    int sum = 0;
    PriorityQueue<Integer> pool = new PriorityQueue<>();
    for (Worker worker : workers) {
      pool.offer(-worker.quality);
      sum += worker.quality;
      if (pool.size() > K) {
        sum += pool.poll();
      }
      if (pool.size() == K) {
        ans = Math.min(ans, sum * worker.ratio());
      }
    }
    return ans;
  }
}


class Worker implements Comparable<Worker> {
  int quality;
  int wage;
  
  public Worker(int quality, int wage) {
    this.quality = quality;
    this.wage = wage;
  }
  
  public double ratio() {
    return (double) wage / quality;
  }
  
  public int compareTo(Worker other) {
    return Double.compare(ratio(), other.ratio());
  }
}
