package bit.model;

import java.util.Date;

public class Comment {
    private Integer commId;

    private Integer commStar;

    private String commContext;

    private Integer commClient;

    private Integer commServer;

    private Date commDatetime;

    private Integer commStatus;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public Integer getCommStar() {
        return commStar;
    }

    public void setCommStar(Integer commStar) {
        this.commStar = commStar;
    }

    public String getCommContext() {
        return commContext;
    }

    public void setCommContext(String commContext) {
        this.commContext = commContext == null ? null : commContext.trim();
    }

    public Integer getCommClient() {
        return commClient;
    }

    public void setCommClient(Integer commClient) {
        this.commClient = commClient;
    }

    public Integer getCommServer() {
        return commServer;
    }

    public void setCommServer(Integer commServer) {
        this.commServer = commServer;
    }

    public Date getCommDatetime() {
        return commDatetime;
    }

    public void setCommDatetime(Date commDatetime) {
        this.commDatetime = commDatetime;
    }

    public Integer getCommStatus() {
        return commStatus;
    }

    public void setCommStatus(Integer commStatus) {
        this.commStatus = commStatus;
    }
}