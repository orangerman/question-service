drop table if exists `question`;
create table question
(
    id         int auto_increment,
    questioner_Id varchar(32)  not null,
    title      varchar(255) not null,
    detail     varchar(255),
    constraint question_pk
        primary key (id)
);