--liquibase formatted sql

--changeset Ilyas:1
CREATE TABLE IF NOT EXISTS students
(
    id          bigserial PRIMARY KEY,
    age         integer      NOT NULL,
    family      varchar(255) NOT NULL,
    groups      varchar(255) NOT NULL,
    name        varchar(255) NOT NULL,
    total_score integer,
    CONSTRAINT uq_students_family_name_group UNIQUE (family, name, groups)
);

CREATE TABLE IF NOT EXISTS item_ratings
(
    id         bigserial PRIMARY KEY,
    item       varchar(255) NOT NULL,
    rating     integer      NOT NULL,
    student_id bigint,
    CONSTRAINT fk_item_ratings_students
        FOREIGN KEY (student_id)
            REFERENCES students (id)
);