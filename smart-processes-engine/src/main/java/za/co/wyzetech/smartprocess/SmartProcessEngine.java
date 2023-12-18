package za.co.wyzetech.smartprocess;

import za.co.wyzetech.smartprocess.process.SmartProcess;

import java.util.UUID;

public interface SmartProcessEngine {
    SmartProcess createNewStateItem(String externalRef);

    SmartProcess findStateItemById(UUID randomUUID);

    void process(String externalRef, String action);
}
