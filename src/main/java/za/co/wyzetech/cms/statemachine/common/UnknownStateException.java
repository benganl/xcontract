package za.co.wyzetech.cms.statemachine.common;

public class UnknownStateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnknownStateException(String message) {
	super(message);
    }
}
