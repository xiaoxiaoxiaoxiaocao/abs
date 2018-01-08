package abs.pubs.domain;
/**
 * 节目包详情，里面包含了节目包id和其中包含的素材的id
 * @author 曹起坤
 *
 */
public class ProMaterial {
    private Integer proId;

    private String materialId;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }
}