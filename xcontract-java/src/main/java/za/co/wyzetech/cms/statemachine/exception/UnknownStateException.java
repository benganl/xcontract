package za.co.wyzetech.cms.statemachine.exception;

public class UnknownStateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnknownStateException(String message) {
	super(message);
    }
}
