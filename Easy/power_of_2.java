public class Solution {
    public boolean isPowerOfTwo(int n) {
        int i=0;
        int c=0;
        while(true)
        {
        	if(Math.pow(2, i)==n)
        	{
        		c=1;
        		break;
        	}
        	else if(Math.pow(2, i)>n)
        	{
        		break;
        	}
        	i++;
        }
        
        if(c==1)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
}