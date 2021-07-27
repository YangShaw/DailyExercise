package logprocess;

public class Conn {

    String ts;
    String uid;
    String id_orig_h;
    String id_orig_p;
    String id_resp_h;
    String id_resp_p;
    String proto;
    String service;
    String duration;
    String orig_bytes;
    String resp_bytes;
    String conn_state;
    String local_orig;
    String local_resp;
    String missed_bytes;
    String history;
    String orig_pkts;
    String orig_ip_bytes;
    String resp_pkts;
    String resp_ip_bytes;
    String tunnel_parents;


    public Conn(String ts, String uid, String id_orig_h, String id_orig_p, String id_resp_h, String id_resp_p, String proto, String service, String duration, String orig_bytes, String resp_bytes, String conn_state, String local_orig, String local_resp, String missed_bytes, String history, String orig_pkts, String orig_ip_bytes, String resp_pkts, String resp_ip_bytes, String tunnel_parents) {
        this.ts = ts;
        this.uid = uid;
        this.id_orig_h = id_orig_h;
        this.id_orig_p = id_orig_p;
        this.id_resp_h = id_resp_h;
        this.id_resp_p = id_resp_p;
        this.proto = proto;
        this.service = service;
        this.duration = duration;
        this.orig_bytes = orig_bytes;
        this.resp_bytes = resp_bytes;
        this.conn_state = conn_state;
        this.local_orig = local_orig;
        this.local_resp = local_resp;
        this.missed_bytes = missed_bytes;
        this.history = history;
        this.orig_pkts = orig_pkts;
        this.orig_ip_bytes = orig_ip_bytes;
        this.resp_pkts = resp_pkts;
        this.resp_ip_bytes = resp_ip_bytes;
        this.tunnel_parents = tunnel_parents;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId_orig_h() {
        return id_orig_h;
    }

    public void setId_orig_h(String id_orig_h) {
        this.id_orig_h = id_orig_h;
    }

    public String getId_orig_p() {
        return id_orig_p;
    }

    public void setId_orig_p(String id_orig_p) {
        this.id_orig_p = id_orig_p;
    }

    public String getId_resp_h() {
        return id_resp_h;
    }

    public void setId_resp_h(String id_resp_h) {
        this.id_resp_h = id_resp_h;
    }

    public String getId_resp_p() {
        return id_resp_p;
    }

    public void setId_resp_p(String id_resp_p) {
        this.id_resp_p = id_resp_p;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getOrig_bytes() {
        return orig_bytes;
    }

    public void setOrig_bytes(String orig_bytes) {
        this.orig_bytes = orig_bytes;
    }

    public String getResp_bytes() {
        return resp_bytes;
    }

    public void setResp_bytes(String resp_bytes) {
        this.resp_bytes = resp_bytes;
    }

    public String getConn_state() {
        return conn_state;
    }

    public void setConn_state(String conn_state) {
        this.conn_state = conn_state;
    }

    public String getLocal_orig() {
        return local_orig;
    }

    public void setLocal_orig(String local_orig) {
        this.local_orig = local_orig;
    }

    public String getLocal_resp() {
        return local_resp;
    }

    public void setLocal_resp(String local_resp) {
        this.local_resp = local_resp;
    }

    public String getMissed_bytes() {
        return missed_bytes;
    }

    public void setMissed_bytes(String missed_bytes) {
        this.missed_bytes = missed_bytes;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getOrig_pkts() {
        return orig_pkts;
    }

    public void setOrig_pkts(String orig_pkts) {
        this.orig_pkts = orig_pkts;
    }

    public String getOrig_ip_bytes() {
        return orig_ip_bytes;
    }

    public void setOrig_ip_bytes(String orig_ip_bytes) {
        this.orig_ip_bytes = orig_ip_bytes;
    }

    public String getResp_pkts() {
        return resp_pkts;
    }

    public void setResp_pkts(String resp_pkts) {
        this.resp_pkts = resp_pkts;
    }

    public String getResp_ip_bytes() {
        return resp_ip_bytes;
    }

    public void setResp_ip_bytes(String resp_ip_bytes) {
        this.resp_ip_bytes = resp_ip_bytes;
    }

    public String getTunnel_parents() {
        return tunnel_parents;
    }

    public void setTunnel_parents(String tunnel_parents) {
        this.tunnel_parents = tunnel_parents;
    }
}
