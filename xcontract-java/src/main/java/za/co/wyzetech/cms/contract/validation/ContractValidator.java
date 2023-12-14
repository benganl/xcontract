package za.co.wyzetech.cms.contract.validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.wyzetech.cms.contract.model.Contract;
import za.co.wyzetech.cms.contract.model.Party;

@Slf4j
@Service
public class ContractValidator {

    public static List<String> validate(Contract contract) {
	List<String> errors = new ArrayList<>();

	if (isValidParties(contract.getParties())) {
	    errors.add(ValidationErrors.ONE_PARTY_TO_CONTRACT);
	}

	if (isValidDates(contract.getStartDate(), contract.getEndDate())) {
	    errors.add(ValidationErrors.START_DATE_ERROR);
	}

	return errors;
    }

    private static boolean isValidParties(Set<Party> parties) {
	return parties != null && parties.size() < 2;
    }

    private static boolean isValidDates(Date startDate, Date endDate) {
	return startDate != null && endDate != null && startDate.after(endDate);
    }
}
