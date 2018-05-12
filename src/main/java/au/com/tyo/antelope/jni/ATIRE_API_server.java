/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package au.com.tyo.antelope.jni;

public class ATIRE_API_server {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ATIRE_API_server(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ATIRE_API_server obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        AntelopeJNI.delete_ATIRE_API_server(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public ATIRE_API_server() {
    this(AntelopeJNI.new_ATIRE_API_server(), true);
  }

  public void initialize() {
    AntelopeJNI.ATIRE_API_server_initialize(swigCPtr, this);
  }

  public SWIGTYPE_p_ATIRE_API get_atire() {
    long cPtr = AntelopeJNI.ATIRE_API_server_get_atire(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_ATIRE_API(cPtr, false);
  }

  public void set_params(int argc, SWIGTYPE_p_p_char argv) {
    AntelopeJNI.ATIRE_API_server_set_params__SWIG_0(swigCPtr, this, argc, SWIGTYPE_p_p_char.getCPtr(argv));
  }

  public void set_params(String args) {
    AntelopeJNI.ATIRE_API_server_set_params__SWIG_1(swigCPtr, this, args);
  }

  public void start() {
    AntelopeJNI.ATIRE_API_server_start(swigCPtr, this);
  }

  public void loop() {
    AntelopeJNI.ATIRE_API_server_loop(swigCPtr, this);
  }

  public void poll() {
    AntelopeJNI.ATIRE_API_server_poll(swigCPtr, this);
  }

  public void poll_and_process() {
    AntelopeJNI.ATIRE_API_server_poll_and_process(swigCPtr, this);
  }

  public void process_command() {
    AntelopeJNI.ATIRE_API_server_process_command(swigCPtr, this);
  }

  public void interrupt() {
    AntelopeJNI.ATIRE_API_server_interrupt(swigCPtr, this);
  }

  public void finish() {
    AntelopeJNI.ATIRE_API_server_finish(swigCPtr, this);
  }

  public int run() {
    return AntelopeJNI.ATIRE_API_server_run__SWIG_0(swigCPtr, this);
  }

  public int run(String files) {
    return AntelopeJNI.ATIRE_API_server_run__SWIG_1(swigCPtr, this, files);
  }

  public void ant() {
    AntelopeJNI.ATIRE_API_server_ant(swigCPtr, this);
  }

  public void start_stats() {
    AntelopeJNI.ATIRE_API_server_start_stats(swigCPtr, this);
  }

  public void end_stats() {
    AntelopeJNI.ATIRE_API_server_end_stats(swigCPtr, this);
  }

  public SWIGTYPE_p_ANT_stats get_stats() {
    long cPtr = AntelopeJNI.ATIRE_API_server_get_stats(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_ANT_stats(cPtr, false);
  }

  public long get_search_time() {
    return AntelopeJNI.ATIRE_API_server_get_search_time(swigCPtr, this);
  }

  public String version() {
    return AntelopeJNI.ATIRE_API_server_version(swigCPtr, this);
  }

  public void prompt() {
    AntelopeJNI.ATIRE_API_server_prompt(swigCPtr, this);
  }

  public int is_interrupted() {
    return AntelopeJNI.ATIRE_API_server_is_interrupted(swigCPtr, this);
  }

  public void set_interrupted(int interrupted) {
    AntelopeJNI.ATIRE_API_server_set_interrupted(swigCPtr, this, interrupted);
  }

  public int has_new_command() {
    return AntelopeJNI.ATIRE_API_server_has_new_command(swigCPtr, this);
  }

  public void insert_command(String cmd) {
    AntelopeJNI.ATIRE_API_server_insert_command(swigCPtr, this, cmd);
  }

  public void set_outchannel(int type) {
    AntelopeJNI.ATIRE_API_server_set_outchannel(swigCPtr, this, type);
  }

  public int search(String query) {
    return AntelopeJNI.ATIRE_API_server_search__SWIG_0(swigCPtr, this, query);
  }

  public int search() {
    return AntelopeJNI.ATIRE_API_server_search__SWIG_1(swigCPtr, this);
  }

  public void goto_result(int index) {
    AntelopeJNI.ATIRE_API_server_goto_result(swigCPtr, this, index);
  }

  public String result_to_json() {
    return AntelopeJNI.ATIRE_API_server_result_to_json(swigCPtr, this);
  }

  public int next_result() {
    return AntelopeJNI.ATIRE_API_server_next_result(swigCPtr, this);
  }

  public void result_to_outchannel(int last_to) {
    AntelopeJNI.ATIRE_API_server_result_to_outchannel__SWIG_0(swigCPtr, this, last_to);
  }

  public void result_to_outchannel() {
    AntelopeJNI.ATIRE_API_server_result_to_outchannel__SWIG_1(swigCPtr, this);
  }

  public String load_document() {
    return AntelopeJNI.ATIRE_API_server_load_document(swigCPtr, this);
  }

  public String get_current_document() {
    return AntelopeJNI.ATIRE_API_server_get_current_document(swigCPtr, this);
  }

  public final static int CHANNEL_FILE = AntelopeJNI.ATIRE_API_server_CHANNEL_FILE_get();
  public final static int CHANNEL_SOCKET = AntelopeJNI.ATIRE_API_server_CHANNEL_SOCKET_get();
  public final static int CHANNEL_STREAM = AntelopeJNI.ATIRE_API_server_CHANNEL_STREAM_get();

}
