package za.co.wyzetech.cms.statemachine.common;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.handler.EventDto;
import za.co.wyzetech.cms.statemachine.handler.StateItemDto;
import za.co.wyzetech.cms.statemachine.handler.TransitionDto;
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
}