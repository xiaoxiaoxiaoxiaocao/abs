package abs.pubs.domain;

public class Playplanlist {
    private Integer id;

    private Integer playplanid;

    private Integer materialid;

    private Integer playduration;

    private Integer playorder;

    private String propackage;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayplanid() {
        return playplanid;
    }

    public void setPlayplanid(Integer playplanid) {
        this.playplanid = playplanid;
    }

    public Integer getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }

    public Integer getPlayduration() {
        return playduration;
    }

    public void setPlayduration(Integer playduration) {
        this.playduration = playduration;
    }

    public Integer getPlayorder() {
        return playorder;
    }

    public void setPlayorder(Integer playorder) {
        this.playorder = playorder;
    }

    public String getPropackage() {
        return propackage;
    }

    public void setPropackage(String propackage) {
        this.propackage = propackage == null ? null : propackage.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}