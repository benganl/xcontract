package za.co.wyzetech.cms.contract.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import za.co.wyzetech.cms.contract.dto.ContractDto;
import za.co.wyzetech.cms.contract.model.Contract;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    Contract convert(ContractDto dto);

    ContractDto convert(Contract contract);
}
