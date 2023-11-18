package com.example.onlinediary.repository;

import com.example.onlinediary.entity.ItemRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRatingRepository extends JpaRepository<ItemRating, Long> {
    /**
     * Найти оценку по itemId и studentId
     * @param itemId Название предмета
     * @param id id студента
     * @return студент с обновленной оценкой
     */
    @Query("select i from ItemRating i where i.itemId = ?1 and i.student.id = ?2")
    Optional<ItemRating> findByItemId(String itemId, Long id);


}