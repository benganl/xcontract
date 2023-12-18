package za.co.wyzetech.smartprocess.exception;

import lombok.Data;

@Data
public class ExternalRefException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;

    public ExternalRefException() {
        super();
    }

    public ExternalRefException(final Integer code, final String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
