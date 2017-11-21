package exception;

public class PickNullPieceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PickNullPieceException(String message) {
		super(message);
	}
}