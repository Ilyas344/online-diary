package com.example.onlinediary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String family;
    private String name;
    private int age;
    @Column(name = "groups")
    private String group;
    @Column(name = "total_score")
    private int totalScore;
    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private List<ItemRating> itemRatings;

    @Override
    public String toString() {
        return "Студент " + family + " " + name +
                ", " + age +
                " лет, группа " + group +
                ", общий балл " + totalScore +
                ", Рейтинг предметов " + itemRatings + "; \n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && totalScore == student.totalScore && Objects.equals(id, student.id) && Objects.equals(family, student.family) && Objects.equals(name, student.name) && Objects.equals(group, student.group) && Objects.equals(itemRatings, student.itemRatings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, family, name, age, group, totalScore, itemRatings);
    }
}
