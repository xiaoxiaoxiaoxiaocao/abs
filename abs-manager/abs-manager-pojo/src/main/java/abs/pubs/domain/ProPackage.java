package abs.pubs.domain;

import java.util.Date;

public class ProPackage {
    private Integer id;

    private Integer states;

    private Integer pkgType;

    private String pkgName;

    private Integer operator;

    private Date updttime;

    private String ptaskid;

    private String rtaskid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Integer getPkgType() {
        return pkgType;
    }

    public void setPkgType(Integer pkgType) {
        this.pkgType = pkgType;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName == null ? null : pkgName.trim();
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getUpdttime() {
        return updttime;
    }

    public void setUpdttime(Date updttime) {
        this.updttime = updttime;
    }

    public String getPtaskid() {
        return ptaskid;
    }

    public void setPtaskid(String ptaskid) {
        this.ptaskid = ptaskid == null ? null : ptaskid.trim();
    }

    public String getRtaskid() {
        return rtaskid;
    }

    public void setRtaskid(String rtaskid) {
        this.rtaskid = rtaskid == null ? null : rtaskid.trim();
    }
}