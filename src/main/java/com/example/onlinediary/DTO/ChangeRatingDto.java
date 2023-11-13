package com.example.onlinediary.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.io.Serializable;


/**
 * DTO for {@link com.example.onlinediary.entity.Student}
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность для изменения рейтинга студента")
public class ChangeRatingDto implements Serializable {
    String family;
    String name;
    String group;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    Integer totalScore;
    ItemRatingDto itemRatings;


}