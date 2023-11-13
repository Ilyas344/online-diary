package com.example.onlinediary.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность для рейтинга студента")
public class ItemRatingDto implements Serializable {
    private String itemId;
    @Min(1)
    @Max(5)
    private int rating;
}