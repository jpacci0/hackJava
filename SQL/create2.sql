-- create TABLE students(
--     id bigint auto_increment primary key,
--     nome varchar(100)
-- );

-- CREATE TABLE courses(
--     id bigint auto_increment primary key,
--     course_name varchar(100)
-- );

CREATE TABLE students_courses(
    student_id BIGINT references students(id),
    course_id BIGINT references courses(id)
);