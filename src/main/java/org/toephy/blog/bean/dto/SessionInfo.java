package org.toephy.blog.bean.dto;

/**
 * Created by Toephy on 2017.4.25 15:30
 */
public class SessionInfo {

    private String sessionId;
    private long uid;
    private long createTime;
    private boolean isValid = true;
    private long expire;

    public SessionInfo() {
        super();
    }

    public SessionInfo(String sessionId, long uid, long createTime) {
        super();
        this.sessionId = sessionId;
        this.uid = uid;
        this.createTime = createTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public boolean isExpired() {
        return this.expire != 0 && System.currentTimeMillis() - this.createTime > this.expire;
    }

    @Override
    public String toString() {
        return "SessionInfo [uid=" + uid + ", sessionId=" + sessionId + ", createTime=" + createTime + ", expire="
                + expire + ", isValid=" + isValid + "]";
    }

}
