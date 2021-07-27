package logprocess;

public class HTTP {

    String ts;
    String uid;
    String id_orig_h;
    String id_orig_p;

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

    String id_resp_h;
    String id_resp_p;
    String trans_depth;
    String method;
    String host;
    String uri;
    String referrer;
    String version;
    String user_agent;
    String origin;
    String request_body_len;
    String response_body_len;
    String status_code;
    String status_msg;
    String info_code;
    String info_msg;
    String tags;
    String username;
    String password;
    String proxied;
    String orig_fuids;
    String orig_filenames;
    String orig_mime_types;
    String resp_fuids;
    String resp_filenames;
    String resp_mime_types;

    public HTTP(){

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



    public String getTrans_depth() {
        return trans_depth;
    }

    public void setTrans_depth(String trans_depth) {
        this.trans_depth = trans_depth;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getRequest_body_len() {
        return request_body_len;
    }

    public void setRequest_body_len(String request_body_len) {
        this.request_body_len = request_body_len;
    }

    public String getResponse_body_len() {
        return response_body_len;
    }

    public void setResponse_body_len(String response_body_len) {
        this.response_body_len = response_body_len;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(String status_msg) {
        this.status_msg = status_msg;
    }

    public String getInfo_code() {
        return info_code;
    }

    public void setInfo_code(String info_code) {
        this.info_code = info_code;
    }

    public String getInfo_msg() {
        return info_msg;
    }

    public void setInfo_msg(String info_msg) {
        this.info_msg = info_msg;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProxied() {
        return proxied;
    }

    public void setProxied(String proxied) {
        this.proxied = proxied;
    }

    public String getOrig_fuids() {
        return orig_fuids;
    }

    public void setOrig_fuids(String orig_fuids) {
        this.orig_fuids = orig_fuids;
    }

    public String getOrig_filenames() {
        return orig_filenames;
    }

    public void setOrig_filenames(String orig_filenames) {
        this.orig_filenames = orig_filenames;
    }

    public String getOrig_mime_types() {
        return orig_mime_types;
    }

    public void setOrig_mime_types(String orig_mime_types) {
        this.orig_mime_types = orig_mime_types;
    }

    public String getResp_fuids() {
        return resp_fuids;
    }

    public void setResp_fuids(String resp_fuids) {
        this.resp_fuids = resp_fuids;
    }

    public String getResp_filenames() {
        return resp_filenames;
    }

    public void setResp_filenames(String resp_filenames) {
        this.resp_filenames = resp_filenames;
    }

    public String getResp_mime_types() {
        return resp_mime_types;
    }

    public void setResp_mime_types(String resp_mime_types) {
        this.resp_mime_types = resp_mime_types;
    }
}
