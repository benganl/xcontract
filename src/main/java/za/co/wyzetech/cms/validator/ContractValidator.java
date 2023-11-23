package za.co.wyzetech.cms.validator;

import za.co.wyzetech.cms.model.Contract;
import za.co.wyzetech.cms.model.Party;

import java.util.Date;
import java.util.Set;

public class ContractValidator {

    public static boolean validate(Contract contract) {
        return isValidParties(contract.getParties()) &&
                isValidDates(contract.getStartDate(), contract.getEndDate());
    }

    private static boolean isValidParties(Set<Party> parties) {
        return parties != null && parties.size() >= 2;
    }

    private static boolean isValidDates(Date startDate, Date endDate) {
        return startDate != null && endDate != null && startDate.before(endDate);
    }
}
