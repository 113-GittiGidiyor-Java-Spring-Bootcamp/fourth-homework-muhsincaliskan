package com.patika.hw4.mappers;

import com.patika.hw4.dto.ExceptionLoggerDTO;

import com.patika.hw4.entity.ExceptionLogger;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExceptionLoggerMapper {


    ExceptionLogger mapFromExceptionLoggerDTOtoExceptionLogger(ExceptionLoggerDTO exceptionLoggerDTO);
    ExceptionLoggerDTO maprFromExceptionLoggertoExceptionLoggerDTO(ExceptionLogger exceptionLogger);
}
