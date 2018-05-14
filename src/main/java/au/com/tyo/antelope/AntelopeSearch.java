package au.com.tyo.antelope;

import java.util.List;

public class AntelopeSearch {

    /**
     * Total hits
     */
    private long total;

    /**
     * Total search time
     */
    private long time;

    /**
     * Page Index
     */
    private long page;

    /**
     * Page Size
     */
    private long size;

    /**
     */
    List results;

    public AntelopeSearch(long total, long time, long page, long size) {
        this.total = total;
        this.time = time;
        this.page = page;
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }
}
