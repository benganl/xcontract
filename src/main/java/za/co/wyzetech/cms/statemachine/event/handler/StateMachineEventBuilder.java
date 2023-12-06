package za.co.wyzetech.cms.statemachine.event.handler;

public class StateMachineEventBuilder {

    protected TransitionDto transition;
    protected StateItemDto stateItem;

    public static StateMachineEventBuilder init() {
	return new StateMachineEventBuilder();
    }

    public StateMachineEventBuilder transition(TransitionDto transition) {
	this.transition = transition;
	return this;
    }

    public StateMachineEventBuilder stateItem(StateItemDto stateItem) {
	this.stateItem = stateItem;
	return this;
    }

    public StateMachineEvent build() {
	return new StateMachineEvent(this);
    }
}
