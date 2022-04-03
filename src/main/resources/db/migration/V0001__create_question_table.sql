create table question
(
    id         varchar(32) primary key,
    questionId varchar(32)  not null,
    title      varchar(255) not null,
    detail     varchar(255)
);