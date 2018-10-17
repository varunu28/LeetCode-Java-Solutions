/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        int total = 0;
        int read = 4;
        while(total <= n && read == 4){
            char[] temp = new char[4];  
            read = read4(temp); 
            total += read;

            for(int i = 0; i < read && count < n; i++) {
                buf[count++] = temp[i];
            }
        }
        
        return count;
    }
}
