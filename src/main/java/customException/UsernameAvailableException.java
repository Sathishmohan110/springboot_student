package customException;


public class UsernameAvailableException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameAvailableException(String message) {
		super(message);
	}

}
