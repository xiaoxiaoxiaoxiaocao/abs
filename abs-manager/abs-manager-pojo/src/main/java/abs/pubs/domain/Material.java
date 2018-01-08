package abs.pubs.domain;

import java.util.Date;
/**
 * 素材实体类，封装了素材的各种属性
 * @author 曹起坤
 *
 */
public class Material {
    private Integer id;

    private String name;

    private Integer type;

    private Integer size;

    private Integer adduserid;

    private Date addtime;

    private Integer checkuserid;

    private Date checktime;

    private Short state;

    private Integer timesize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getAdduserid() {
        return adduserid;
    }

    public void setAdduserid(Integer adduserid) {
        this.adduserid = adduserid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getCheckuserid() {
        return checkuserid;
    }

    public void setCheckuserid(Integer checkuserid) {
        this.checkuserid = checkuserid;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Integer getTimesize() {
        return timesize;
    }

    public void setTimesize(Integer timesize) {
        this.timesize = timesize;
    }
}