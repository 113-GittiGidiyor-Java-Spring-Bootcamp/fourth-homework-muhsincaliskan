package com.patika.hw4.repository;

import com.patika.hw4.entity.ExceptionLogger;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExceptionLoggerRepository extends PagingAndSortingRepository<ExceptionLogger,Long> {
}
