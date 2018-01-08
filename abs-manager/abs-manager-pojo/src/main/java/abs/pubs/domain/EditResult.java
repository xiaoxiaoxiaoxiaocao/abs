package abs.pubs.domain;

import java.util.Date;

public class EditResult {
	
	private Integer materialId;
	private String materialName;
	private String type;
	private Integer materialSize;
	private Date addTime;
	private Integer playduration;
	private Integer playorder;
	private String zipName;
	private String addUsername;
	private String proPackage;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProPackage() {
		return proPackage;
	}
	public void setProPackage(String proPackage) {
		this.proPackage = proPackage;
	}
	
	public String getAddUsername() {
		return addUsername;
	}
	public void setAddUsername(String addUsername) {
		this.addUsername = addUsername;
	}
	public String getZipName() {
		return zipName;
	}
	public void setZipName(String zipName) {
		this.zipName = zipName;
	}
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public Integer getMaterialSize() {
		return materialSize;
	}
	public void setMaterialSize(Integer materialSize) {
		this.materialSize = materialSize;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
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
	@Override
	public String toString() {
		return "EditResult [materialId=" + materialId + ", materialName=" + materialName + ", type=" + type
				+ ", materialSize=" + materialSize + ", addTime=" + addTime + ", playduration=" + playduration
				+ ", playorder=" + playorder + ", zipName=" + zipName + ", addUsername=" + addUsername + ", proPackage="
				+ proPackage + "]";
	}
	
	

}
