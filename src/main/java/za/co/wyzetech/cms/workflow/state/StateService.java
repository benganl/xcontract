package za.co.wyzetech.cms.workflow.state;

public interface StateService {

    State newState();

    String create(State state);

}
