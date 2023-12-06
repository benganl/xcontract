package za.co.wyzetech.cms.statemachine.common;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.event.handler.EventDto;
import za.co.wyzetech.cms.statemachine.event.handler.StateDto;
import za.co.wyzetech.cms.statemachine.event.handler.StateItemDto;
import za.co.wyzetech.cms.statemachine.event.handler.TransitionDto;
import za.co.wyzetech.cms.statemachine.state.State;
import za.co.wyzetech.cms.statemachine.stateitem.StateItem;
import za.co.wyzetech.cms.statemachine.transition.Transition;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    StateItem map(StateItemDto stateItem);
    StateItemDto map(StateItem stateItem);

    Transition map(TransitionDto stateItem);
    TransitionDto map(Transition stateItem);

    Event map(EventDto event);
    EventDto map(Event event);

    State map(StateDto state);
    StateDto map(State state);
}