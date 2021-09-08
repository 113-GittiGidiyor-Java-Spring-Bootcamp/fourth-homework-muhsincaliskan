package com.patika.hw4.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.entity.Student;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {
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
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Number phoneNumber;
    @JsonManagedReference
    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList=new ArrayList<>();

}
