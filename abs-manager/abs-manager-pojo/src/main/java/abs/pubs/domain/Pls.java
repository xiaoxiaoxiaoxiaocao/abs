package abs.pubs.domain;

public class Pls {
    private Integer id;

    private String name;

    private String areatype;

    private String stardate;

    private String enddate;

    private String stdtime;

    private String edtime;

    private String playmode;

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

    public String getAreatype() {
        return areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype == null ? null : areatype.trim();
    }

    public String getStardate() {
        return stardate;
    }

    public void setStardate(String stardate) {
        this.stardate = stardate == null ? null : stardate.trim();
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate == null ? null : enddate.trim();
    }

    public String getStdtime() {
        return stdtime;
    }

    public void setStdtime(String stdtime) {
        this.stdtime = stdtime == null ? null : stdtime.trim();
    }

    public String getEdtime() {
        return edtime;
    }

    public void setEdtime(String edtime) {
        this.edtime = edtime == null ? null : edtime.trim();
    }

    public String getPlaymode() {
        return playmode;
    }

    public void setPlaymode(String playmode) {
        this.playmode = playmode == null ? null : playmode.trim();
    }

	public Pls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pls(String name, String areatype, String stardate, String enddate, String stdtime, String edtime) {
		super();
		this.name = name;
		this.areatype = areatype;
		this.stardate = stardate;
		this.enddate = enddate;
		this.stdtime = stdtime;
		this.edtime = edtime;
	}

	
    
}