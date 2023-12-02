package za.co.wyzetech.cms.statemachine.state;

public enum States {
    NEW("NEW"),
    COMPLETE("COMPLETE"),
    DRAFT("DRAFT"),
    NEGOTIATION("NEGOTIATION"),
    REVIEW("REVIEW"),
    PROCESSING("PROCESSING"),
    APPROVED("APPROVED"),
    AOD("AOD"),
    SETTLED("SETTLED"),
    NAOD("NOAD"),
    LOD("LOD"),
    LITIGATION("LITIGATION"),
    EXECUTION("EXECUTION"),
    EXCEPTION("EXCEPTION");
    
    private String value;
    
    States(String value) {
	this.value = value;
    }
    
    public String value() {
	return value;
    }
}