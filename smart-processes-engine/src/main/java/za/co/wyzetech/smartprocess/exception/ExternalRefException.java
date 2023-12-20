package za.co.wyzetech.smartprocess.exception;

import lombok.Data;

@Data
public class ExternalRefException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExternalRefException() {
	super();
    }

    public ExternalRefException(final String message) {
	super(message);
    }
}
