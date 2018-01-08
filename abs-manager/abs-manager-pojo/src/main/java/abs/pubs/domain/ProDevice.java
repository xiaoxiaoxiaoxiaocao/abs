package abs.pubs.domain;

public class ProDevice {
    private Integer id;

    private Integer proid;

    private Integer deviceid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

	public ProDevice() {
		super();
	}

	public ProDevice(Integer proid, Integer deviceid) {
		super();
		this.proid = proid;
		this.deviceid = deviceid;
	}
	
    
}