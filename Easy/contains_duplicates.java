import java.util.Arrays;
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length; 
        Arrays.sort(nums);
        int c=1;
        for(int i=0;i<n;i++)
        {
            if(i!=n-1)
            {
                if(nums[i]==nums[i+1])
                {
                    c=0;
                    break;
                }
            }
        }
        
        if(n==0 || n==1)
        {
            return false;
        }
        else
        {
            if(c==0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}