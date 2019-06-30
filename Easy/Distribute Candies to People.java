class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] count = new int[num_people];
        int idx = 0;
        int currCount = 0;
        int startCandy = 1;
        
        while (currCount < candies) {
            count[idx++] += currCount + startCandy > candies ? candies - currCount : startCandy;
            currCount += startCandy++;
            if (idx == num_people) {
                idx = 0;
            }
        }
        
        return count;
    }
}
