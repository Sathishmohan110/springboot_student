package customException;

import java.util.List;

public class SdetailsValidationException extends RuntimeException {
	private String message;
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public List<Serror> getError() {
		return error;
	}



	public void setError(List<Serror> error) {
		this.error = error;
	}



	private List<Serror> error;
	
public SdetailsValidationException(String message, List<Serror> error) {
		super(message);
		this.message = message;
		this.error = error;
	}



public SdetailsValidationException() {}
}
