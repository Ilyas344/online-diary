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
//    @Query("""
//            SELECT s.family, s.name, s.group, AVG(ir.rating) AS average_rating
//            FROM Student s
//            JOIN ItemRating ir ON s.id = ir.student.id
//            WHERE s.group = :group
//            GROUP BY s.id, s.name
//            """)
//    @Query("""
//        select new DTO.AverageScoreDto(
//            s.family, s.name, s.group, AVG(ir.rating) AS average_rating
//        )
//        from AverageScoreDto s
//        JOIN ItemRating ir ON s.id = ir.student.id
//        WHERE s.group = :group\s
//       GROUP BY s.id, s.name
//    """)
//    List<AverageScoreDto > getAverageScore(@Param("group") String group);

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

    @Query("""
                SELECT s.id
                FROM Student s
                WHERE s.family = :family AND s.name = :name AND s.group = :group
            """)
    Long getIdStudent(
            @Param("family") String family,
            @Param("name") String name,
            @Param("group") String group
    );

    @Query("select s from Student s where s.family = :family and s.name = :name and s.group = :group")
    Optional<Student> findStudent(
            @Param("family") String family,
            @Param("name") String name,
            @Param("group") String group
    );

}