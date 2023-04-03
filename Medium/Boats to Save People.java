class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        while (left <= right) {
            int capacity = people[right--];
            if (left <= right && capacity + people[left] <= limit) {
                left++;
            }
            count++;
        }        
        return count;
    }
}
