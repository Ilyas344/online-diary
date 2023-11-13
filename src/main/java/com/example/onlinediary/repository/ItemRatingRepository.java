package com.example.onlinediary.repository;

import com.example.onlinediary.entity.ItemRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRatingRepository extends JpaRepository<ItemRating, Long> {
    @Query("select i from ItemRating i where i.itemId = ?1 and i.student.id = ?2")
    ItemRating findByItemId(String itemId, Long id);


}