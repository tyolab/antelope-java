package au.com.tyo.antelope;

public class AntelopeDoc {

    public long docid;
    private int rank;

    float rsv;

    String title;
    String snippet;

    String document_name;

    String doc;

    public String toString() {
        return "rank: " + rank + ", " + "name: " + document_name + ", " + "id: " + docid + ", " + "rsv: " + rsv;
    }
}
