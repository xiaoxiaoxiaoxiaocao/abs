package abs.pubs.utils;

//自定义异常类(保存业务级别异常)
@SuppressWarnings("serial")
public class CustomException extends Exception{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
