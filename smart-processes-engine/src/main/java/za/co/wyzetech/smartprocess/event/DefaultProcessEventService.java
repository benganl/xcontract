package za.co.wyzetech.smartprocess.event;

import org.springframework.stereotype.Service;

@Service
class DefaultProcessEventService implements ProcessEventService {
    private final ProcessEventRepository processEventRepository;

    public DefaultProcessEventService(ProcessEventRepository processEventRepository) {
        this.processEventRepository = processEventRepository;
    }

    @Override
    public ProcessEvent eventByName(String name) {
        ProcessEvent processEvent = processEventRepository.findByName(name);
        return processEvent;
    }
}
