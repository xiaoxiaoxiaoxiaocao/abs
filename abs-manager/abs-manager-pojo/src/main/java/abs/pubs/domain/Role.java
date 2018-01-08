package abs.pubs.domain;

public class Role {
    private Integer id;

    private String name;

    private String comment;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String name, String comment) {
		super();
		this.name = name;
		this.comment = comment;
	}
    
}