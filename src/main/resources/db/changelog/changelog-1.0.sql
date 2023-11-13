--liquibase formatted sql

--changeset Ilyas:1
create table if not exists students
(
    id          bigserial
        primary key,
    age         integer not null,
    family      varchar(255),
    groups      varchar(255),
    name        varchar(255),
    total_score integer
);

create table if not exists item_ratings
(
    id         bigserial
        primary key,
    item       varchar(255),
    rating     integer not null,
    student_id bigint
        constraint fkkkwo1fhdgexai63q5lbntwcjl
            references students
);