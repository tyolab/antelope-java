package au.com.tyo.antelope;

import com.google.gson.Gson;

import java.util.ArrayList;

import au.com.tyo.antelope.jni.ATIRE_API_server;

public class Antelope {

    private String opts;

    private ATIRE_API_server server;

    private Gson gson;

    public Antelope(String opts) {
        this.opts = opts;

        server.set_params(opts);
        server.initialize();

        gson = new Gson();
    }

    static {
        System.loadLibrary("antelope_jni");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

//		if (args.length == 0) {
//			atire_apis.run_atire("-q:+-findex+/mnt/sdcard/Android/data/au.com.tyo.wiki.offline/index.aspt+-fdoclist+/mnt/sdcard/Android/data/au.com.tyo.wiki.offline/doclist.aspt");
//		}
//		atire_apis.run_atire(args[0]);
    }

    public void start() {
        server.start();
    }

    public String search(String query, boolean loadContent) {
        return search(query, 1, 20, true, loadContent);
    }

    public String search(String query, int page, int size, boolean needdata, boolean loadContent) {
        if (page < 1) page = 1;
        int index = (page - 1) * size;

        long hits = server.search(query);

        if (index > 0)
            server.goto_result(index);

        // server.result_to_outchannel();
        AntelopeSearchResult searchResult = new AntelopeSearchResult(hits, page, size, server.get_search_time());
        String results = null;

        if (needdata) {
            int ret = server.next_result();
            int count = 0;
            while (ret > 0 && count < size) {
                String hit = server.result_to_json();

                AntelopeDoc obj;
                try {
                    obj = gson.fromJson(hit, AntelopeDoc.class);
                }
                catch (Exception err) {
                    obj = null;
                }

                if (null != obj) {
                    if (searchResult.list == null)
                        searchResult.list = new ArrayList();

                    if (loadContent) {
                        String doc = server.load_document();
                        obj.doc = (doc);
                    }

                    searchResult.list.add(obj);
                }

                ret = server.next_result();

                ++count;
            }
        }

        //logger.info({query: query, index: index, page_size: size, hits: hits, size: results.list.length});

        return results;
    }

    public String loadDocument(int docid) {
        return server.get_document(docid);
    }

    public void sendCommand(String cmd) {
        server.insert_command(cmd);
        server.process_command();
    }
}
