/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(startUrl);
        String hostname = getHostname(startUrl);
        while(!stack.isEmpty()) {
            String popped = stack.pop();
            visited.add(popped);
            List<String> connectedUrls = htmlParser.getUrls(popped);
            for (String url : connectedUrls) {
                if (!visited.contains(url) && url.contains(hostname)) {
                    stack.push(url);
                }
            }
        }
        return new ArrayList<>(visited);
    }
    
    private String getHostname(String url) {
        String[] splits = url.split("/");
        return splits[2];
    }
}
