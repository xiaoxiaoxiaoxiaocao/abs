package abs.pubs.domain;


public class Usercat {
    private Integer id;

    private Integer parentid;

    private Integer cityid;

    private String name;

    private Integer isparent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getIsparent() {
        return isparent;
    }

    public void setIsparent(Integer isparent) {
        this.isparent = isparent;
    }

	public Usercat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usercat( Integer parentid, Integer cityid, String name, Integer isparent) {
		super();
		this.parentid = parentid;
		this.cityid = cityid;
		this.name = name;
		this.isparent = isparent;
	}
    
    
}