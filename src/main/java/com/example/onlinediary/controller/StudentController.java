package com.example.onlinediary.controller;

import com.example.onlinediary.DTO.AddItemRatingDto;
import com.example.onlinediary.DTO.AddStudentDto;
import com.example.onlinediary.DTO.AverageScoreDto;
import com.example.onlinediary.DTO.ChangeRatingDto;
import com.example.onlinediary.entity.Student;
import com.example.onlinediary.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Tag(name = "Студенты", description = "Методы для работы со студентами")

public class StudentController {
    private final StudentService service;


    @Operation(summary = "Получить студентов в определенном классе",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(
                                    schema = @Schema(implementation = AverageScoreDto.class))})
            })
    @GetMapping("/")
    public ResponseEntity<List<AverageScoreDto>> getAverageScore(
            @RequestParam("group") @Parameter(description = "Группа") String group) {
        return ResponseEntity.ok(service.getAverageScore((group)));
    }

    @Operation(summary = "Изменить оценку студенту",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(
                                    schema = @Schema(implementation = ChangeRatingDto.class))}),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            })
    @PutMapping("/")
    public ResponseEntity<ChangeRatingDto> updateRating(
            @RequestBody ChangeRatingDto changeRatingDto) {
        return ResponseEntity.ok(service.updateRating(changeRatingDto));
    }

    @Operation(summary = "Добавить студента",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(
                                    schema = @Schema(implementation = AddStudentDto.class))})
            })
    @PostMapping("/")
    public ResponseEntity<AddStudentDto> addStudent(
            @RequestBody Student student) {
        return ResponseEntity.ok(service.addStudent(student));
    }

    @Operation(summary = "Добавить студента с предметом и оценкой",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(
                                    schema = @Schema(implementation = AddStudentDto.class))})
            })
    @PostMapping("/items")
    public ResponseEntity<AddItemRatingDto> addItemsAndRatings(
            @RequestBody AddItemRatingDto addItemRatingDto) {

        return ResponseEntity.ok(service.addItemsAndRatingsToStudent(addItemRatingDto));


    }
}
