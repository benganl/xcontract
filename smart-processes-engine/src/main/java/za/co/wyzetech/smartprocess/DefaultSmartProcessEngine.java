package za.co.wyzetech.smartprocess;

import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import za.co.wyzetech.smartprocess.event.ProcessEventService;
import za.co.wyzetech.smartprocess.exception.ExternalRefException;
import za.co.wyzetech.smartprocess.exception.InvalidStateException;
import za.co.wyzetech.smartprocess.process.SmartProcess;
import za.co.wyzetech.smartprocess.process.SmartProcessService;

@Slf4j
@Component
class DefaultSmartProcessEngine implements SmartProcessEngine {

    private final SmartProcessService smartProcessService;
    private final ProcessEventService processEventService;

    public DefaultSmartProcessEngine(SmartProcessService smartProcessService, ProcessEventService processEventService) {
	this.smartProcessService = smartProcessService;
	this.processEventService = processEventService;
    }

    @Override
    public Mono<SmartProcess> createNewSmartProcess(String externalRef) {
	if (Objects.isNull(externalRef)) {
	    throw new ExternalRefException("External ref required to create a new process!!!");
	}
	return smartProcessService.create(externalRef);
    }

    @Override
    public Mono<SmartProcess> findSmartProcessById(UUID id) {
	if (Objects.isNull(id)) {
	    throw new InvalidStateException("Id is null");
	}
	return smartProcessService.findSmartProcessById(id);
    }

    @Override
    public Mono<SmartProcess> findSmartProcessByExternalRef(String externalRef) {
	if (Objects.isNull(externalRef)) {
	    throw new ExternalRefException("External reference is null!!!");
	}
	return smartProcessService.smartProcessByExternalRef(externalRef);
    }

    @Override
    public void process(String externalRef, String eventName) {
	log.info("Processing for: {}-{}", externalRef, eventName);
	// final SmartProcess smartProcess =
	// smartProcessService.smartProcessByExternalRef(externalRef);
	// final ProcessEvent processEvent = processEventService.eventByName(eventName);
    }
}
