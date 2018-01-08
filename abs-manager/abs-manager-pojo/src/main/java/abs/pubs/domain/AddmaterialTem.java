package abs.pubs.domain;

public class AddmaterialTem {
    private Integer id;

    private String name;

    private Integer materialid;

    private Short background;

    private Integer priority;

    private Integer playcnt;

    private String text;

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

    public Integer getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }

    public Short getBackground() {
        return background;
    }

    public void setBackground(Short background) {
        this.background = background;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPlaycnt() {
        return playcnt;
    }

    public void setPlaycnt(Integer playcnt) {
        this.playcnt = playcnt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}