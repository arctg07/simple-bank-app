package com.bankapp.config;

import com.bankapp.exception.MapperException;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Configuration;

/**
 * Mapstruct configuration class.
 *
 * @author Iurii Ivanov
 */

@Configuration
@org.mapstruct.MapperConfig(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unexpectedValueMappingException = MapperException.class)
public interface MapperConfig {}
