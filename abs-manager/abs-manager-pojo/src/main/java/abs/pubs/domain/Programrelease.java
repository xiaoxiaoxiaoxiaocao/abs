package abs.pubs.domain;

import java.util.Date;
/**
 * 节目包发布相关信息
 * @author 曹起坤
 *
 */
public class Programrelease {
    private Integer id;

    private Integer deviceid;

    private Integer playplanid;

    private String adduser;

    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getPlayplanid() {
        return playplanid;
    }

    public void setPlayplanid(Integer playplanid) {
        this.playplanid = playplanid;
    }

    public String getAdduser() {
        return adduser;
    }

    public void setAdduser(String adduser) {
        this.adduser = adduser == null ? null : adduser.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}