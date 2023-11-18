package com.example.onlinediary.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность для поиска среднего рейтинга студента")
public class AverageScoreDto {
    private String family;
    private String name;
    private String group;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @PositiveOrZero
    private double averageScore;


}