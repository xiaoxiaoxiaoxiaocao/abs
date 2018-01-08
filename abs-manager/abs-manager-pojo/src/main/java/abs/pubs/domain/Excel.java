package abs.pubs.domain;

public class Excel {
	private String deviceName;
	private String guestName;
	private Integer age;
	private String gender;
	private String info;
	private String date;
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Excel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Excel(String deviceName, String guestName, Integer age, String gender, String info, String date) {
		super();
		this.deviceName = deviceName;
		this.guestName = guestName;
		this.age = age;
		this.gender = gender;
		this.info = info;
		this.date = date;
	}
	
	
}
