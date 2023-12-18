package za.co.wyzetech.smartprocess.exception;

public class UnknownStateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnknownStateException(String message) {
        super(message);
    }
}
