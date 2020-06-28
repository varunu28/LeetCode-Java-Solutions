class Solution {
  public double average(int[] salary) {
    int minSalary = salary[0];
    int maxSalary = salary[0];
    int n = salary.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += salary[i];
      minSalary = Math.min(minSalary, salary[i]);
      maxSalary = Math.max(maxSalary, salary[i]);
    }
    sum -= (maxSalary + minSalary);
    return ((double) sum) / (n - 2);
  }
}
