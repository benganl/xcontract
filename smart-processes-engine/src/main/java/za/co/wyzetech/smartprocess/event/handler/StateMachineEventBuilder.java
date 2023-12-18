package za.co.wyzetech.smartprocess.event.handler;

public class StateMachineEventBuilder {

    protected TransitionDto transition;
    protected SmartProcessDto stateItem;

    public static StateMachineEventBuilder init() {
        return new StateMachineEventBuilder();
    }

    public StateMachineEventBuilder transition(TransitionDto transition) {
        this.transition = transition;
        return this;
    }

    public StateMachineEventBuilder stateItem(SmartProcessDto stateItem) {
        this.stateItem = stateItem;
        return this;
    }

    public StateMachineEvent build() {
        return new StateMachineEvent(this);
    }
}
