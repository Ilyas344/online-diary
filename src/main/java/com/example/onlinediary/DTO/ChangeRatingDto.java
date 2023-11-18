package com.example.onlinediary.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;



/**
 * DTO for {@link com.example.onlinediary.entity.Student}
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность для изменения рейтинга студента")
public class ChangeRatingDto {
    String family;
    String name;
    String group;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    Integer totalScore;
    @Valid
    ItemRatingDto itemRatings;


}