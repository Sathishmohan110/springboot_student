package customException;

public class Serror{

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;
	public Serror() {}

	public Serror(String message) {
		super();
		this.message = message;
	}

}
