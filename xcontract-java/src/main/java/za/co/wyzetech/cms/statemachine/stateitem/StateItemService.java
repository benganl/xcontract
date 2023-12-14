package za.co.wyzetech.cms.statemachine.stateitem;

import java.util.UUID;

public interface StateItemService {

    StateItem stateItemById(UUID id);

    StateItem create(StateItem stateItem);

    StateItem stateItemByExternalRef(String externalRef);

}
