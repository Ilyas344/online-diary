package com.example.onlinediary.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;




@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Valid
@Schema(description = "Сущность для добавления рейтинга студента")
public class AddItemRatingDto {
    String family;
    String name;
    @Positive(message = "Age must be positive")
    int age;
    String group;
    @Valid
    ItemRatingDto itemRatingDto;
}