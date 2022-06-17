/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
  public List<String> crawl(String startUrl, HtmlParser htmlParser) {
    int startIdx = startUrl.indexOf("//") + 2;
    int endIdx = startUrl.indexOf("/", startIdx) == -1 ? startUrl.length() : startUrl.indexOf("/", startIdx);
    String domain = startUrl.substring(0, endIdx);
    Set<String> visitedUrls = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(startUrl);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        String removed = queue.remove();
        visitedUrls.add(removed);
        List<String> urls = htmlParser.getUrls(removed);
        for (String url : urls) {
          if (url.startsWith(domain) && !visitedUrls.contains(url)) {
            visitedUrls.add(url);
            queue.add(url);
          }
        }
      }
    }
    return new ArrayList<>(visitedUrls);
  }
}
