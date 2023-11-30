package za.co.wyzetech.cms.integration.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import za.co.wyzetech.cms.contract.model.Contract;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    Contract convert(ContractDto dto);

    ContractDto convert(Contract contract);
}
