package com.patika.hw4.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolAppErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
