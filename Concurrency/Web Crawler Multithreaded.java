/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
import java.net.URI;
import java.net.URISyntaxException;


class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        ResultRecord resultRecord = new ResultRecord();
        CrawlTask task = new CrawlTask(
            startUrl, htmlParser, resultRecord, UrlUtil.parseHostname(startUrl));
        try {
            task.start();
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultRecord.getResultList();
    }
}

class CrawlTask extends Thread {
    
    private final String url;
    private final HtmlParser htmlParser;
    private final ResultRecord resultRecord;
    private final String parentHost;
    
    public CrawlTask(String url, 
                     HtmlParser htmlParser, 
                     ResultRecord resultRecord,
                     String parentHost) {
        this.url = url;
        this.htmlParser = htmlParser;
        this.resultRecord = resultRecord;
        this.parentHost = parentHost;
    }
    
    public void run() {
        String hostname = UrlUtil.parseHostname(url);
        if (!hostname.equals(parentHost)) {
            return;
        }
        if (resultRecord.addIfNotExists(url)) {
            List<String> childUrls = htmlParser.getUrls(url);
            List<CrawlTask> tasks = new ArrayList<>();
            for (String childUrl : childUrls) {
                tasks.add(new CrawlTask(
                    childUrl, htmlParser, resultRecord, parentHost));
            }
            try {
                for (CrawlTask task : tasks) {
                    task.start();
                }
                for (CrawlTask task : tasks) {
                    task.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UrlUtil {
    
    public static String parseHostname(String url) {
        try {
            URI uri = new URI(url);
            return uri.getHost();
        } catch(URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ResultRecord {

    private Set<String> urls;
    private Semaphore mutex;
    
    public ResultRecord() {
        this.urls = new HashSet<>();
        this.mutex = new Semaphore(1);
    }
    
    public boolean addIfNotExists(String url) {
        try {
            this.mutex.acquire();
            boolean added = this.urls.add(url);
            this.mutex.release();
            return added;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    } 
    
    public List<String> getResultList() {
        return new ArrayList<>(urls);
    }
}
