package au.com.tyo.antelope;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import au.com.tyo.antelope.jni.ATIRE_API_server;

public class Antelope extends AntelopeClient {

    private String opts;

    private ATIRE_API_server server;

    private Gson gson;

    public Antelope(String opts) {
        this.opts = opts;

        server = new ATIRE_API_server();

        server.set_params(opts);
        server.initialize();

        gson = new Gson();
    }

    private static boolean nativeLibraryLoaded = false;

    public static void loadNativeLibrary() {
        if (!nativeLibraryLoaded) {
            System.loadLibrary(dylibName);
            nativeLibraryLoaded = true;
        }
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

    public List<AntelopeDoc> search(String query, boolean loadContent) throws Exception {
        return search(query, 1, 20, loadContent);
    }

    public List<AntelopeDoc> search(String query, int page, int size, boolean needdata) throws Exception {
        if (page < 1) page = 1;
        int index = (page - 1) * size;

        long hits = server.search(query);

        if (index > 0)
            server.goto_result(index);

        // server.result_to_outchannel();
        AntelopeSearchResult searchResult = new AntelopeSearchResult(hits, page, size, server.get_search_time());
        List<AntelopeDoc> results = search(query, page, size);

        if (results != null && needdata)
            for (AntelopeDoc antelopeDoc : results)
                antelopeDoc.doc = loadDocument((int) antelopeDoc.docid);

        //logger.info({query: query, index: index, page_size: size, hits: hits, size: results.list.length});

        return results;
    }

    public String loadDocument(int docid) {
        return server.get_document(docid);
    }

    public String sendCommand(String cmd) {
        server.insert_command(cmd);
        server.process_command();

        return server.get_outchannel_content();
    }

    @Override
    public List<AntelopeDoc> search(String query, int pageIndex, int pageSize) throws Exception {
        List list = null;
        AntelopeSearchResult searchResult = new AntelopeSearchResult(hits, pageIndex, pageSize, server.get_search_time());

        int ret = server.next_result();
        int count = 0;
        if (ret > 0) {
            list = new ArrayList();
            while (ret > 0 && count < pageSize) {
                String hit = server.result_to_json();

                AntelopeDoc obj;
                try {
                    obj = gson.fromJson(hit, AntelopeDoc.class);
                } catch (Exception err) {
                    obj = null;
                }

                if (null != obj) {
                    if (searchResult.list == null)
                        searchResult.list = new ArrayList();

                    searchResult.list.add(obj);
                }

                ret = server.next_result();

                ++count;
            }
        }

        return list;
    }

    @Override
    protected String getDocumentInternal(long id) {
        return server.get_document((int) id);
    }
}
