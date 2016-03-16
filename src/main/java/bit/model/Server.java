package bit.model;

public class Server {
    private Integer serverId;

    private String serverName;

    private String serverTel;

    private String serverPid;

    private String serverNum;

    private String serverPassword;

    private String serverCode;

    private Float serverPoint;

    private String serverPhoto;

    private Integer serverStation;

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName == null ? null : serverName.trim();
    }

    public String getServerTel() {
        return serverTel;
    }

    public void setServerTel(String serverTel) {
        this.serverTel = serverTel == null ? null : serverTel.trim();
    }

    public String getServerPid() {
        return serverPid;
    }

    public void setServerPid(String serverPid) {
        this.serverPid = serverPid == null ? null : serverPid.trim();
    }

    public String getServerNum() {
        return serverNum;
    }

    public void setServerNum(String serverNum) {
        this.serverNum = serverNum == null ? null : serverNum.trim();
    }

    public String getServerPassword() {
        return serverPassword;
    }

    public void setServerPassword(String serverPassword) {
        this.serverPassword = serverPassword == null ? null : serverPassword.trim();
    }

    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode == null ? null : serverCode.trim();
    }

    public Float getServerPoint() {
        return serverPoint;
    }

    public void setServerPoint(Float serverPoint) {
        this.serverPoint = serverPoint;
    }

    public String getServerPhoto() {
        return serverPhoto;
    }

    public void setServerPhoto(String serverPhoto) {
        this.serverPhoto = serverPhoto == null ? null : serverPhoto.trim();
    }

    public Integer getServerStation() {
        return serverStation;
    }

    public void setServerStation(Integer serverStation) {
        this.serverStation = serverStation;
    }
}