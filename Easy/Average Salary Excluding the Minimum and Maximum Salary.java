class Solution {
    public double average(int[] salary) {
        int minSalary = salary[0];
        int maxSalary = salary[0];
        double totalSalary = 0;
        for (int s : salary) {
            minSalary = Math.min(minSalary, s);
            maxSalary = Math.max(maxSalary, s);
            totalSalary += s;
        }
        return (totalSalary - minSalary - maxSalary) / (salary.length - 2);
    }
}
