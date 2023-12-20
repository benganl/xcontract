package za.co.wyzetech.smartprocess.process;

import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import za.co.wyzetech.smartprocess.exception.ExternalRefException;
import za.co.wyzetech.smartprocess.state.ProcessState;
import za.co.wyzetech.smartprocess.state.ProcessStateService;
import za.co.wyzetech.smartprocess.state.States;

@Service
class DefaultSmartProcessService implements SmartProcessService {

    private final SmartProcessRepository smartProcessRepository;
    private final ProcessStateService processStateService;
    private final SmartProcessFactory smartProcessFactory;

    public DefaultSmartProcessService(SmartProcessRepository smartProcessRepository, ProcessStateService processStateService,
	    SmartProcessFactory smartProcessFactory) {
	this.smartProcessRepository = smartProcessRepository;
	this.processStateService = processStateService;
	this.smartProcessFactory = smartProcessFactory;
    }

    @Override
    public Mono<SmartProcess> findSmartProcessById(UUID id) {
	if (Objects.isNull(id)) {
	    throw new ExternalRefException("Id is required!!!");
	}
	return smartProcessRepository.getById(id);
    }

    @Override
    public Mono<SmartProcess> create(String externalRef) {
	if (Objects.isNull(externalRef)) {
	    throw new ExternalRefException("A SmartProcess instance is required to proceed!");
	}
	final ProcessState newProcessState = processStateService.statusByName(States.NEW.value());
	SmartProcess smartProcess = smartProcessFactory.create(externalRef, newProcessState);
	return smartProcessRepository.save(smartProcess);
    }

    @Override
    public Mono<SmartProcess> smartProcessByExternalRef(String externalRef) {
	if (Objects.isNull(externalRef)) {
	    throw new ExternalRefException("External reference is null!");
	}
	if (externalRef.isEmpty()) {
	    throw new ExternalRefException("External reference is empty!");
	}
	return smartProcessRepository.findByExternalRef(externalRef);
    }
}
