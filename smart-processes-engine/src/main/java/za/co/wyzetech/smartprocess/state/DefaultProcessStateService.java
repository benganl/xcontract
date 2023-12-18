package za.co.wyzetech.smartprocess.state;

import org.springframework.stereotype.Service;

@Service
class DefaultProcessStateService implements ProcessStateService {

    private final ProcessStateRepository processStateRepository;

    public DefaultProcessStateService(ProcessStateRepository processStateRepository) {
        this.processStateRepository = processStateRepository;
    }

    @Override
    public ProcessState statusByName(String stateName) {
        return processStateRepository.findByName(stateName);
    }
}
