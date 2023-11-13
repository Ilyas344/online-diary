package com.example.onlinediary.service.Impl;

import com.example.onlinediary.DTO.*;
import com.example.onlinediary.entity.ItemRating;
import com.example.onlinediary.entity.Student;
import com.example.onlinediary.exception.StudentNotFoundException;
import com.example.onlinediary.repository.ItemRatingRepository;
import com.example.onlinediary.repository.StudentRepository;
import com.example.onlinediary.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ItemRatingRepository itemRatingRepository;

    @Override
    public List<AverageScoreDto> getAverageScore(String group) {
        log.info("getAverageScore group {}", group);
        List<AverageScoreDto> averageScoreDto = studentRepository.getAverageScore(group);
        if (averageScoreDto.isEmpty()) {
            log.warn("Студентов в {} нет", group);
            throw new StudentNotFoundException("Студентов в " + group + " нет");
        }
        return averageScoreDto;
    }


    @Override
    public ChangeRatingDto updateRating(ChangeRatingDto changeRatingDto) {
        String family = changeRatingDto.getFamily();
        String name = changeRatingDto.getName();
        String group = changeRatingDto.getGroup();
        String item = changeRatingDto.getItemRatings().getItemId();
        int rating = changeRatingDto.getItemRatings().getRating();
        var optionalStudent = studentRepository.findStudent(family, name, group);
        var student = optionalStudent.orElseThrow(() -> new StudentNotFoundException("Студент не найден"));
        int totalScore;
        ItemRating itemRating = itemRatingRepository.findByItemId(item, student.getId());
        if (itemRating == null) {
            itemRating = new ItemRating(item, rating);
            itemRating.setStudent(student);
            totalScore = rating;
        } else {
            totalScore = rating - itemRating.getRating();
        }

        student.setTotalScore(student.getTotalScore() + totalScore);
        itemRating.setRating(rating);
        student.getItemRatings().add(itemRating);
        studentRepository.save(student);
        itemRatingRepository.save(itemRating);
        return new ChangeRatingDto(family, name, group, student.getTotalScore(), new ItemRatingDto(item, rating));

    }

    @Override
    public AddStudentDto addStudent(Student student) {
        studentRepository.save(student);
        return new AddStudentDto(student.getId(), student.getFamily(), student.getName(), student.getAge(), student.getGroup());
    }

    @Override
    public AddItemRatingDto addItemsAndRatingsToStudent(
            AddItemRatingDto addItemRatingDto) {
        String family = addItemRatingDto.getFamily();
        String name = addItemRatingDto.getName();
        int age = addItemRatingDto.getAge();
        String group = addItemRatingDto.getGroup();
        String item = addItemRatingDto.getItemRatingDto().getItemId();
        int rating = addItemRatingDto.getItemRatingDto().getRating();
        var optionalStudent = studentRepository.findStudent(family, name, group);
        Student student = optionalStudent.orElseGet(() -> {
            Student newStudent = new Student();
            newStudent.setFamily(family);
            newStudent.setAge(age);
            newStudent.setName(name);
            newStudent.setGroup(group);
            return newStudent;
        });

        ItemRating itemRating = new ItemRating(item, rating);
        itemRating.setStudent(student);
        itemRatingRepository.save(itemRating);
        return addItemRatingDto;
    }


}
