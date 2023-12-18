package za.co.wyzetech.smartprocess.common;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.co.wyzetech.smartprocess.config.ProcessConfig;
import za.co.wyzetech.smartprocess.event.ProcessEvent;
import za.co.wyzetech.smartprocess.event.handler.ProcessEventDto;
import za.co.wyzetech.smartprocess.event.handler.ProcessStateDto;
import za.co.wyzetech.smartprocess.event.handler.SmartProcessDto;
import za.co.wyzetech.smartprocess.event.handler.TransitionDto;
import za.co.wyzetech.smartprocess.process.SmartProcess;
import za.co.wyzetech.smartprocess.state.ProcessState;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    SmartProcess map(SmartProcessDto stateItem);

    SmartProcessDto map(SmartProcess smartProcess);

    ProcessConfig map(TransitionDto stateItem);

    TransitionDto map(ProcessConfig stateItem);

    ProcessEvent map(ProcessEventDto event);

    ProcessEventDto map(ProcessEvent processEvent);

    ProcessState map(ProcessStateDto state);

    ProcessStateDto map(ProcessState processState);
}