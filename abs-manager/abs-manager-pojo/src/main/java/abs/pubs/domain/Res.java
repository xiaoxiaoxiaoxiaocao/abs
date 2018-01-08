package abs.pubs.domain;

public class Res {
    private String resid;

	private String resname;

	private String area;

	private Integer playcnt;

	private String stdtime;

	private String endtime;

	private String priority;

	private Integer plsId;

	private String href;

	private String md5;

	private Integer filesize;

	private Byte defau;

	private String text;

	public String getResid() {
		return resid;
	}

	public void setResid(String resid) {
		this.resid = resid == null ? null : resid.trim();
	}

	public String getResname() {
		return resname;
	}

	public void setResname(String resname) {
		this.resname = resname == null ? null : resname.trim();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area == null ? null : area.trim();
	}

	public Integer getPlaycnt() {
		return playcnt;
	}

	public void setPlaycnt(Integer playcnt) {
		this.playcnt = playcnt;
	}

	public String getStdtime() {
		return stdtime;
	}

	public void setStdtime(String stdtime) {
		this.stdtime = stdtime == null ? null : stdtime.trim();
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime == null ? null : endtime.trim();
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority == null ? null : priority.trim();
	}

	public Integer getPlsId() {
		return plsId;
	}

	public void setPlsId(Integer plsId) {
		this.plsId = plsId;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href == null ? null : href.trim();
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5 == null ? null : md5.trim();
	}

	public Integer getFilesize() {
		return filesize;
	}

	public void setFilesize(Integer filesize) {
		this.filesize = filesize;
	}

	public Byte getDefau() {
		return defau;
	}

	public void setDefau(Byte defau) {
		this.defau = defau;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}


}