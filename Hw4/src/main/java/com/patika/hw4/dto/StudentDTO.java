package com.patika.hw4.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.patika.hw4.entity.Course;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDTO {
    @ApiModelProperty(example = "11111111111")
    @NotNull(message = "ID is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Long id;
    @ApiModelProperty(example = "Muhsin")
    @NotBlank(message = "Instructor Name is mandatory")
    private String name;

    @ApiModelProperty(example = "Uskudar/Istanbul")
    @NotBlank(message = "Course code is mandatory")
    private String address;

    @ApiModelProperty(example = "12312312410")
    private LocalDate birthDate;
    @JsonManagedReference
    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList=new ArrayList<>();
}
