import java.util.ArrayList;
public class Solution {
    public boolean isHappy(int n) {
	    	ArrayList al=new ArrayList();
	    	int c=0;
	    	
	    	while(true)
	    	{
	    		int sum=0;
	    		while(n>0)
	    		{
	    			sum+=(n%10)*(n%10);
	    			n/=10;
	    		}
	    		
	    		if(sum==1)
	    		{
	    			c=1;
	    			break;
	    		}
	    		
	    		if(al.contains(sum))
	    		{
	    			break;
	    		}
	    		else
	    		{
	    			al.add(sum);
	    			n=sum;
	    		}
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