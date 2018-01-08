package abs.pubs.domain;

public class ProPls {
    private Integer id;

    private Integer proId;

    private Integer plsId;

    private String name;

    private String message;

    private String fontsize;

    private String tcolor;

    private String bcolor;

    private String location;

    private String speed;

    private String createtime;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getPlsId() {
        return plsId;
    }

    public void setPlsId(Integer plsId) {
        this.plsId = plsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getFontsize() {
        return fontsize;
    }

    public void setFontsize(String fontsize) {
        this.fontsize = fontsize == null ? null : fontsize.trim();
    }

    public String getTcolor() {
        return tcolor;
    }

    public void setTcolor(String tcolor) {
        this.tcolor = tcolor == null ? null : tcolor.trim();
    }

    public String getBcolor() {
        return bcolor;
    }

    public void setBcolor(String bcolor) {
        this.bcolor = bcolor == null ? null : bcolor.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed == null ? null : speed.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}