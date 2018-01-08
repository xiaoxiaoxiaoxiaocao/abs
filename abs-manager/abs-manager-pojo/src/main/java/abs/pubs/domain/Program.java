package abs.pubs.domain;

import java.util.Date;

public class Program {
    private Integer zipid;

    private Date ziptime;

    private String zipname;

    private Integer zipuserid;

    private Byte addlist;

    private Integer materialcount;

    public Integer getZipid() {
        return zipid;
    }

    public void setZipid(Integer zipid) {
        this.zipid = zipid;
    }

    public Date getZiptime() {
        return ziptime;
    }

    public void setZiptime(Date ziptime) {
        this.ziptime = ziptime;
    }

    public String getZipname() {
        return zipname;
    }

    public void setZipname(String zipname) {
        this.zipname = zipname == null ? null : zipname.trim();
    }

    public Integer getZipuserid() {
        return zipuserid;
    }

    public void setZipuserid(Integer zipuserid) {
        this.zipuserid = zipuserid;
    }

    public Byte getAddlist() {
        return addlist;
    }

    public void setAddlist(Byte addlist) {
        this.addlist = addlist;
    }

    public Integer getMaterialcount() {
        return materialcount;
    }

    public void setMaterialcount(Integer materialcount) {
        this.materialcount = materialcount;
    }
}