package com.example.onlinediary.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность для добавления студента")
public class AddStudentDto implements Serializable {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    Long id;
    String family;
    String name;
    @Positive(message = "Age must be positive")
    int age;
    String group;





}