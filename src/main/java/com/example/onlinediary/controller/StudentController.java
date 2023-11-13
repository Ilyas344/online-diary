package com.example.onlinediary.controller;

import com.example.onlinediary.DTO.AddItemRatingDto;
import com.example.onlinediary.DTO.AddStudentDto;
import com.example.onlinediary.DTO.AverageScoreDto;
import com.example.onlinediary.DTO.ChangeRatingDto;
import com.example.onlinediary.entity.Student;
import com.example.onlinediary.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
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
    @GetMapping("/{group}")
    public ResponseEntity<List<AverageScoreDto>> getAverageScore(@PathVariable("group") String group) {
        return ResponseEntity.ok(service.getAverageScore(String.valueOf(group)));
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

    //            @RequestParam @Parameter(description = "Фамилия") String family,
//            @RequestParam @Parameter(description = "Имя") String name,
//            @RequestParam @Parameter(description = "Группа") String group,
//            @RequestParam @Parameter(description = "Предмет") String item,
//            @RequestParam @Parameter(description = "Оценка") Integer rating)
//            {
    //       return ResponseEntity.ok(service.updateRating(family, name, group, item, rating));
    //   }
    @Operation(summary = "Добавить студента",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(
                                    schema = @Schema(implementation = AddStudentDto.class))})
            })
    @PostMapping("/")
    public ResponseEntity<AddStudentDto> addStudent(
            @RequestBody Student student)
    //        @RequestParam @Parameter(description = "Фамилия") String family,
//            @RequestParam @Parameter(description = "Имя") String name,
//            @RequestParam @Parameter(description = "Группа") String group,
//            @RequestParam @Parameter(description = "Возраст") Integer age)
    {
        return ResponseEntity.ok(service.addStudent(student));
    }

    @Operation(summary = "Добавить студенту с предмет и оценку",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = {@Content(
                                    schema = @Schema(implementation = AddStudentDto.class))})
            })
    @PostMapping("/addItemsAndRatings")
    public ResponseEntity<AddItemRatingDto> addItemsAndRatings(
            @RequestBody AddItemRatingDto addItemRatingDto) {
//            @RequestParam @Parameter(description = "Фамилия") String family,
//            @RequestParam @Parameter(description = "Имя") String name,
//            @RequestParam @Parameter(description = "Возраст") Integer age,
//            @RequestParam @Parameter(description = "Группа") String group,
//            @RequestParam @Parameter(description = "Предмет") String item,
//            @RequestParam @Parameter(description = "Оценка") Integer rating) {
        return ResponseEntity.ok(service.addItemsAndRatingsToStudent(addItemRatingDto));


    }
}
