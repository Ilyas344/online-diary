package com.example.onlinediary.service;

import com.example.onlinediary.DTO.AddItemRatingDto;
import com.example.onlinediary.DTO.AddStudentDto;
import com.example.onlinediary.DTO.AverageScoreDto;
import com.example.onlinediary.DTO.ChangeRatingDto;
import com.example.onlinediary.entity.Student;

import java.util.List;

public interface StudentService {
    List<AverageScoreDto> getAverageScore(String group);

    ChangeRatingDto updateRating(ChangeRatingDto changeRatingDto);

    AddStudentDto addStudent(Student student);

    AddItemRatingDto addItemsAndRatingsToStudent(AddItemRatingDto addItemRatingDto);

}
