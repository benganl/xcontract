package za.co.wyzetech.smartprocess.state;

public enum States {
    NEW("NEW"),
    EXCEPTION("EXCEPTION"),
    COMPLETE("COMPLETE");

    private String value;

    States(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}