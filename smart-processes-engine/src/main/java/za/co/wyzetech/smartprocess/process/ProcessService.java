package za.co.wyzetech.smartprocess.process;

import java.util.UUID;

public interface ProcessService {

    SmartProcess stateItemById(UUID id);

    SmartProcess create(SmartProcess smartProcess);

    SmartProcess stateItemByExternalRef(String externalRef);

}
