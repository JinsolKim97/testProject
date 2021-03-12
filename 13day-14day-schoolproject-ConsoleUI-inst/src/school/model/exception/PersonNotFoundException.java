package school.model.exception;

public class PersonNotFoundException extends Exception {
	private static final long serialVersionUID = 6939519577998432410L;
	public PersonNotFoundException(String message) {
		super(message);
	}
}
