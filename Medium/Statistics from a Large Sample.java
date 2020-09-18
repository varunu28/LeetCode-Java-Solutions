class Solution {
    public double[] sampleStats(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        double sum = 0;
        int currMin = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;
        int currMod = -1;
        int modCount = 0;
        int count = 0;
        
        for (int i = 0; i < num.length; i++) {
            sum += num[i] * i;
            if (num[i] > 0) {
                currMin = Math.min(currMin, i);
                currMax = Math.max(currMax, i);
                map.put(i, num[i]);
                if (map.get(i) > modCount) {
                    modCount = num[i];
                    currMod = i;
                }
                count += num[i];
            }
        }
        
        return new double[]{
            (double) currMin,
            (double) currMax,
            sum / count,
            count % 2 == 0 ? getEvenMedian(num, count) : getOddMedian(num, count),
            (double) currMod
        };
    }
    
    private double getEvenMedian(int[] num, int count) {
        int p1 = count/2;
        int p2 = count/2 + 1;
        double sum = 0;
        int currCount = 0;
        int i = 0;
        
        while (i < num.length) {
            if (num[i] != 0) {
                currCount += num[i];
                if (currCount >= p1 && currCount >= p2) {
                    return (double) i;
                }
                
                if (currCount >= p1 && currCount < p2) {
                    sum = i;
                    i++;
                    break;
                }
            }   
            
            i++;
        }        
        
        while (i < num.length) {
            if (num[i] != 0) {
                currCount += num[i];
                if (currCount >= p2) {
                    sum += i;
                    break;
                }
            }
            
            i++;
        }
        
        return sum / 2;
    }
    
    private double getOddMedian(int[] num, int count) {
        int p1 = count/2 + 1;
        int currCount = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                currCount += num[i];
                if (currCount >= p1) {
                    return (double) i;
                }
            }
        }
        
        return (double) 1;
    }
}
