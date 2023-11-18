package com.example.onlinediary.service;

import com.example.onlinediary.DTO.AddItemRatingDto;
import com.example.onlinediary.DTO.AverageScoreDto;
import com.example.onlinediary.DTO.ChangeRatingDto;

import java.util.List;

public interface StudentService {
    /**
     * Получить список студентов со средним рейтингом по группе
     * @param group - ученическая группа
     * @return Список студентов группы
     */
    List<AverageScoreDto> getAverageScore(String group);

    /**
     * Обновить оценку студента
     * @param changeRatingDto - объект с данными о рейтинге
     * @return Обновленная оценка студента
     */

    ChangeRatingDto updateRating(ChangeRatingDto changeRatingDto);

    /**
     * Добавить студента
     * @param addItemRatingDto - объект с данными о студенте
     * @return Добавленный студент
     */

    AddItemRatingDto addItemsAndRatingsToStudent(AddItemRatingDto addItemRatingDto);

}
