public class Codec {

    // Encodes a URL to a shortened URL.
    
    Map<String, String> encodeMap = new HashMap<>();
    Map<String, String> decodeMap = new HashMap<>();
    
    public String encode(String longUrl) {
        if (encodeMap.containsKey(longUrl)) {
            return encodeMap.get(longUrl);
        }
        else {
            String encodedUrl = longUrl.substring(0,1);
            encodeMap.put(longUrl, encodedUrl);
            decodeMap.put(encodedUrl, longUrl);
            return encodedUrl;
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
