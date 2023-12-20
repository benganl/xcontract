package za.co.wyzetech.smartprocess.process;

import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;
import za.co.wyzetech.smartprocess.exception.ExternalRefException;
import za.co.wyzetech.smartprocess.state.ProcessState;

@Component
public class SmartProcessFactory {
    private final SmartProcessRepository smartProcessRepository;

    public SmartProcessFactory(SmartProcessRepository smartProcessRepository) {
	this.smartProcessRepository = smartProcessRepository;
    }

    public SmartProcess create(final String externalRef, final ProcessState newProcessState) {
	final SmartProcess smartProcess = new SmartProcess();
	smartProcess.setCurrentState(newProcessState);
	smartProcess.setExternalRef(externalRef);
	smartProcess.setId(UUID.randomUUID());
	return smartProcess;
    }

    public Mono<SmartProcess> get(final String externalRef) {
	if (Objects.isNull(externalRef)) {
	    throw new ExternalRefException("External ref is null!!!");
	}
	if (externalRef.length() < 1) {
	    throw new ExternalRefException("External ref is empty!!!");
	}
	return smartProcessRepository.findByExternalRef(externalRef);
    }
}