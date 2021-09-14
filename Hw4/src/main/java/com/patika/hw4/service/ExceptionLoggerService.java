package com.patika.hw4.service;

import com.patika.hw4.dto.ExceptionLoggerDTO;
import com.patika.hw4.dto.InstructorDTO;
import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.ExceptionLogger;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.exceptions.InstructorIsAlreadyExistException;
import com.patika.hw4.mappers.ExceptionLoggerMapper;
import com.patika.hw4.repository.ExceptionLoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExceptionLoggerService implements BaseService<ExceptionLogger>{
    private final ExceptionLoggerRepository exceptionLoggerRepository;
    private final ExceptionLoggerMapper exceptionLoggerMapper;
    /**
     * @param object
     * @return
     */
    public Optional<ExceptionLogger> save(ExceptionLoggerDTO object) {
        boolean isExists=  exceptionLoggerRepository.existsById(object.getId());

        if (isExists){
            throw new InstructorIsAlreadyExistException("Course is already Exists");
        }
        ExceptionLogger exceptionLogger=exceptionLoggerMapper.mapFromExceptionLoggerDTOtoExceptionLogger(object);
        return Optional.of(exceptionLoggerRepository.save(exceptionLogger));
    }

    @Override
    public List<ExceptionLogger> findAll() {
        return (List<ExceptionLogger>) exceptionLoggerRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public ExceptionLogger update(ExceptionLogger object) {
        return null;
    }
}
