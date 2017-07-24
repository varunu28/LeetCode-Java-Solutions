public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] ans = new String[Math.min(list1.length,list2.length)];
        int c = 0;
        int sum = 999999999;
        for (int i=0;i<list1.length;i++) {
            for (int j=0;j<list2.length;j++)
                if (list1[i].equals(list2[j])) {
                    sum = Math.min(sum,i+j);
                }
        }
        
        for (int i=0;i<list1.length;i++) {
            for (int j=0;j<list2.length;j++)
                if (list1[i].equals(list2[j]) && i+j == sum) {
                    ans[c] = list1[i];
                    c++;
                }
        }
        return Arrays.copyOfRange(ans, 0, c);
    }
}