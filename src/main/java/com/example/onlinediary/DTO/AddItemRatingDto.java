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
@Schema(description = "Сущность для добавления рейтинга студента")
public class AddItemRatingDto implements Serializable {
    String family;
    String name;
    @Positive(message = "Age must be positive")
    int age;
    String group;
    ItemRatingDto itemRatingDto;
}