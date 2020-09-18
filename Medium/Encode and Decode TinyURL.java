public class Codec {

    // Encodes a URL to a shortened URL.
    Map<String, Integer> map = new HashMap<>();
    Map<Integer, String> revMap = new HashMap<>();
    int count = 0;
    String BASE_URL = "http://tinyurl.com/";
    public String encode(String longUrl) {
        if (!map.containsKey(longUrl)) {
            count++;
            map.put(longUrl, count);
            revMap.put(count, longUrl);
        }
        
        return BASE_URL + String.valueOf(map.get(longUrl));
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer code = Integer.parseInt(shortUrl.substring(shortUrl.lastIndexOf('/') + 1));
        return revMap.get(code);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
