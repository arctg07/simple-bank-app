package com.bankapp.mapper;

import com.bankapp.config.MapperConfig;
import com.bankapp.dto.request.AccountRequest;
import com.bankapp.dto.response.AccountResponse;
import com.bankapp.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(config = MapperConfig.class, componentModel = SPRING)
public interface AccountMapper {

    @Mapping(target = "currentBalance", expression = "java(BigDecimal.ZERO)")
    @Mapping(target = "active", defaultValue = "false")
    @Mapping(target = "openDate", expression = "java(LocalDate.now())")
    @Mapping(target = "closeDate", expression = "LocalDate.now().plusYears(DefaultConstants.PERIOD)")
    Account mapTo(AccountRequest accountRequest);

    AccountResponse mapTo(Account account);
}
