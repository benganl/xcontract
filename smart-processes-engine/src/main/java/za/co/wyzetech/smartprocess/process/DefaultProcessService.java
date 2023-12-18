package za.co.wyzetech.smartprocess.process;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class DefaultProcessService implements ProcessService {

    private final ProcessRepository processRepository;

    public DefaultProcessService(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    @Override
    public SmartProcess stateItemById(UUID id) {
        return processRepository.getById(id);
    }

    @Override
    public SmartProcess create(SmartProcess smartProcess) {
        return processRepository.save(smartProcess);
    }

    @Override
    public SmartProcess stateItemByExternalRef(String externalRef) {
        return processRepository.findByExternalRef(externalRef);
    }
}
