CREATE DATABASE kqms;

USE kqms;

CREATE TABLE manager (
     username VARCHAR(15),
     `password` VARCHAR(20)
);

CREATE TABLE student (
     `no` CHAR(11),
     `name` VARCHAR(5),
     sex ENUM('男', '女'),
     age SMALLINT,
     class_name VARCHAR(9)
);

CREATE TABLE kaoqin (
    `date` DATE,
    course_name VARCHAR(10),
    course_section TINYINT,
    course_type ENUM('迟到', '早退', '请假', '旷课'),
    student_name VARCHAR(5),
    student_no CHAR(11)
);