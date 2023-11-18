package com.example.onlinediary.repository;

import com.example.onlinediary.DTO.AverageScoreDto;
import com.example.onlinediary.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
     * Получение списка студентов по группе со средним рейтингом
     * @param group группа
     * @return список студентов
     */
    @Query("""
                select new com.example.onlinediary.DTO.AverageScoreDto(
                    s.family, s.name, s.group, AVG(ir.rating) AS averageScore
                )
                from Student s 
                JOIN s.itemRatings ir
                WHERE s.group = :group
                GROUP BY s.family, s.name, s.group
            """)
    List<AverageScoreDto> getAverageScore(@Param("group") String group);

    /**
     * Поиск студента по его данным
     * @param family фамилия студента
     * @param name имя студента
     * @param group группа студента
     * @return студент
     */
    @Query("select s from Student s where s.family = :family and s.name = :name and s.group = :group")
    Optional<Student> findStudent(
            @Param("family") String family,
            @Param("name") String name,
            @Param("group") String group
    );

}