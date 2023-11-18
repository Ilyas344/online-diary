--liquibase formatted sql

--changeset Ilyas:1
create table if not exists students
(
    id          bigserial primary key,
    age         integer not null,
    family      varchar(255) not null,
    groups      varchar(255) not null,
    name        varchar(255) not null,
    total_score integer
);

create table if not exists item_ratings
(
    id         bigserial primary key,
    item       varchar(255) not null,
    rating     integer not null,
    student_id bigint,
    constraint fk_item_ratings_students
        foreign key (student_id)
            references students (id)
);