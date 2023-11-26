package za.co.wyzetech.cms.integration.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.co.wyzetech.cms.integration.request.v1.ContractDto;
import za.co.wyzetech.cms.model.Contract;


@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    Contract convert(ContractDto dto);

    ContractDto convert(Contract contract);
}
